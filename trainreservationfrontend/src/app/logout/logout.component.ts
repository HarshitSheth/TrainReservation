import { Component, OnInit } from '@angular/core';
import {LoginComponent} from '../login/login.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  static loggedout = false;
  messageLoginToLogout = true;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  evaluate(): void {
    if (null === sessionStorage.getItem('userData')) {
      if (!LogoutComponent.loggedout) {
        this.messageLoginToLogout = true;
      } else {
        LogoutComponent.loggedout = false;
        this.messageLoginToLogout = true;
      }
    } else {
      LoginComponent.loginVerification = false;
      LogoutComponent.loggedout = true;
      sessionStorage.clear();
      this.router.navigate(['']);
      this.messageLoginToLogout = false;
      // return 'Logged out';
    }
  }

  goToLogin() {
    this.router.navigate(['login']);
  }
}
