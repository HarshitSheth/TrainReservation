import { Component, OnInit } from '@angular/core';
import {LoginComponent} from '../login/login.component';

@Component({
  selector: 'app-global-menu',
  templateUrl: './global-menu.component.html',
  styleUrls: ['./global-menu.component.css']
})
export class GlobalMenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  loggedIn(): boolean {
    if(null == sessionStorage.getItem('userData'))
      return false;
    return true;
    //return LoginComponent.loginVerification;
  }

}
