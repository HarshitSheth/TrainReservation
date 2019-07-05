import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }
  ngOnInit() {
  }

  get existingUser(): boolean {
    return (null !== sessionStorage.getItem('userData'));
  }

  get user(): string {
     return sessionStorage.getItem('userData');
  }

  goToLogin() {
    this.router.navigate(['login']);
  }

  goToRegister() {
    this.router.navigate(['register']);
  }

}
