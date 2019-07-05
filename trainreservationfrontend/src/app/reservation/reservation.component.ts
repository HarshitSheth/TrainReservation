import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Classdetails} from '../../classes';
import {PaymentComponent} from '../payment/payment.component';
import {HttpClient} from '@angular/common/http';
import {DataServiceService} from '../data-service.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  static className: string;
  paymentAmount: number;
  validName = true;
  validAge = true;
  availability = true;
  verification = false;
  classChoice: string;
  classIsSelected = true;
  constructor(private router: Router, private http: HttpClient, private dataService: DataServiceService) {
  }

  ngOnInit() {
    if (this.paymentSuccess) {
      this.verification = true;
      this.registerPassenger();
    }
  }

  verifyLogin(): boolean {
    if (null != sessionStorage.getItem('userData')) {
      return true;
    } else {
      this.router.navigate(['login']);
    }
  }

  get paymentSuccess() {
    console.log('Payment success', PaymentComponent.paymentSuccess);
    return PaymentComponent.paymentSuccess;
  }

  classSelect($event: any) {
    this.availability = true;
    this.validName = true;
    this.validAge = true;
    this.verification = false;
    ReservationComponent.className = $event.target.value;
    this.classChoice = $event.target.value;
    this.setPaymentAmount(this.classChoice);
    this.classIsSelected = this.dataService.paymentAmount !== 0;
  }

  setPaymentAmount(classchoice: string) {
    if (classchoice === 'Second Tier') {
      this.dataService.paymentAmount = 2000;
    } else if (classchoice === 'Third Tier') {
      this.dataService.paymentAmount = 1000;
    } else if (classchoice === 'Sleeper') {
      this.dataService.paymentAmount = 500;
    } else if (classchoice === 'General') {
      this.dataService.paymentAmount = 100;
    } else {
      this.dataService.paymentAmount = 0;
    }
  }

  validation(): void {
    if (this.dataService.paymentAmount !== 0) {
      if (!this.validateAge()) {
        if (!this.validateName()) {
          this.verification = false;
          return;
        }
      } else {
        if (!this.validateName()) {
          this.verification = false;
          return;
        } else {
          this.verification = true;
        }
      }
      if (this.verification) {
        const url = 'http://192.168.33.10:8080/verifyClassAvailability';
        this.dataService.passengerDetails.classname = ReservationComponent.className;
        this.http.post<boolean>(url, this.dataService.passengerDetails.classname).subscribe(
          res => {
            if (res) {
              this.availability = true;
              sessionStorage.setItem('reservationProcess', 'true');
              this.router.navigate(['payment']);
            } else {
              this.availability = false;
              return;
            }
          }
        );
      }
    } else {
      this.classIsSelected = false;
    }
}

  registerPassenger() {
      const url = 'http://192.168.33.10:8080/reservation';
      this.http.post<Classdetails>(url, this.dataService.passengerDetails).subscribe(
        res => {
          if (null != res) {
            this.dataService.passengerDetails = res;
          } else {
            return;
          }
        }
      );
      sessionStorage.removeItem('reservationProcess');
   }

  validateName(): boolean {
    if (!this.dataService.passengerDetails.passengername.match('^[a-zA-Z]+(\\s[a-zA-Z]+)*$')) {
      this.validName = false;
      return false;
    } else {
      this.validName = true;
      return true;
    }
  }

  validateAge(): boolean {
    if (!this.dataService.passengerDetails.passengerage.match('^[0-9]+$')) {
      this.validAge = false;
      return false;
    } else {
      this.validAge = true;
      return true;
    }
  }

  // goToReservation() {
  //   this.router.navigate(['reservation']);
  // }

  refresh() {
    PaymentComponent.paymentSuccess = false;
    this.ngOnInit();
  }
}
