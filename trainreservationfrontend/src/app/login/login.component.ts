import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Userinformation} from '../../classes';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  static loginVerification = false;
  user: Userinformation = {
    name: '', email: '', contact: '', username: '', password: ''
  };
  verification = true;

  constructor(private http: HttpClient, private router: Router, private app: AppComponent) { }

  ngOnInit() {
  }

  get loggedIn(): boolean {
    return null != sessionStorage.getItem('userData');
  }

  get name(): string {
    return sessionStorage.getItem('userData');
  }

  login() {
    const url = 'http://13.126.191.183:8080/login';
    this.http.post<Userinformation>(url, this.user).subscribe(
      res => {
        if (null != res) {
          this.verification = true;
          LoginComponent.loginVerification = true;
          sessionStorage.setItem('userData', res.name);
          this.router.navigate(['']);
          this.user.name = res.name;
        } else {
          this.verification = false;
          LoginComponent.loginVerification = false;
          return;
        }
      }
    );
  }

  goToLogout() {
    this.router.navigate(['login']);
  }

  goToRegister() {
    this.router.navigate(['register']);
  }

}
