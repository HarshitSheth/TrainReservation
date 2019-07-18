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

  // static user: string;
  static user: Userinformation = {
    name: '', email: '', contact: '', username: '', password: ''
  };
  static loginVerification = false;
  verification = true;

  constructor(private http: HttpClient, private router: Router, private app: AppComponent) { }

  ngOnInit() {
  }

  get user(): Userinformation {
    return LoginComponent.user;
  }

  get loggedIn(): boolean {
    return null != sessionStorage.getItem('userData');
  }

  get name(): string {
    return sessionStorage.getItem('userData');
  }

  login() {
    const url = 'http://13.126.191.183:8080/login';
    this.http.post<Userinformation>(url, LoginComponent.user).subscribe(
      res => {
        if (null != res) {
          this.verification = true;
          LoginComponent.loginVerification = true;
          sessionStorage.setItem('userData', res.name);
          this.router.navigate(['']);
          LoginComponent.user.name = res.name;
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
