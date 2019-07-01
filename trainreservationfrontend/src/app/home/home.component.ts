import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  existUser = false;

  ngOnInit() {
  }

  get existingUser(): boolean {
    return (null !== sessionStorage.getItem('userData'));
    // return (null !== sessionStorage.getItem('userData') && LoginComponent.loginVerification);
    // return ('' !== LoginComponent.user.name && LoginComponent.loginVerification);
  }

  get user(): string {
     return sessionStorage.getItem('userData');
      // return LoginComponent.user.name;
  }



}
