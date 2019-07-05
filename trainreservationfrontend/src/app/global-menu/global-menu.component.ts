import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-global-menu',
  templateUrl: './global-menu.component.html',
  styleUrls: ['./global-menu.component.css']
})
export class GlobalMenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  loggedIn(): boolean {
    return null != sessionStorage.getItem('userData');
  }

  goToReservation() {
    this.router.navigate(['reservation']);
  }

  goToPassengerDetails() {
    this.router.navigate(['passengerDetails']);
  }

  goToCancelReservation() {
    this.router.navigate(['cancelReservation']);
  }

  goToClassAvailability() {
    this.router.navigate(['classAvailability']);
  }

  goToLogin() {
    this.router.navigate(['login']);
  }

  goToLogout() {
    this.router.navigate(['logout']);
  }

  goToRegister() {
    this.router.navigate(['register']);
  }

  goToHome() {
    this.router.navigate(['']);
  }

}
