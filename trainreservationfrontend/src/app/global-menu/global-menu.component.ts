import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PaymentComponent} from '../payment/payment.component';

@Component({
  selector: 'app-global-menu',
  templateUrl: './global-menu.component.html',
  styleUrls: ['./global-menu.component.css']
})

export class GlobalMenuComponent implements OnInit {

  hamburger = false;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  hamburgerClick() {
    this.hamburger = ! this.hamburger;
  }

  loggedIn(): boolean {
    return null != sessionStorage.getItem('userData');
  }

  goToReservation() {
    PaymentComponent.paymentSuccess = false;
    this.router.navigate(['reservation']);
    this.hamburger = false;
  }

  goToPassengerDetails() {
    this.router.navigate(['passengerDetails']);
    this.hamburger = false;
  }

  goToCancelReservation() {
    this.router.navigate(['cancelReservation']);
    this.hamburger = false;
  }

  goToClassAvailability() {
    this.router.navigate(['classAvailability']);
    this.hamburger = false;
  }

  goToLogin() {
    this.router.navigate(['login']);
    this.hamburger = false;
  }

  goToLogout() {
    this.router.navigate(['logout']);
    this.hamburger = false;
  }

  goToRegister() {
    this.router.navigate(['register']);
    this.hamburger = false;
  }

  goToHome() {
    this.router.navigate(['']);
    this.hamburger = false;
  }

}
