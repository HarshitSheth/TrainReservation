import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Classdetails} from '../../classes';
import {PaymentComponent} from '../payment/payment.component';
import {HttpClient} from '@angular/common/http';
import {DataServiceService} from '../data-service.service';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  static className: string;
  classSelected = true;
  classChoice: string;
  validName = true;
  validAge = true;
  availability = true;
  verification = false;
  ac = null;
  seatsPerCabin = null;
  passengerPerSeat = null;
  luggageCapacity = null;
  reservationSuccess = false;
  constructor(private router: Router, private http: HttpClient, private dataService: DataServiceService, private app: AppComponent) {
  }

  ngOnInit() {
    this.classSelected = true;
    this.dataService.paymentAmount = 0;
    if (this.paymentSuccess) {
      this.verification = true;
      this.registerPassenger();
      this.dataService.paymentAmount = 0;
    }
  }
  //
  // get getClassNotSelected() {
  //   if (ReservationComponent.classSelected === true) {
  //     return true;
  //   }
  // }

  get paymentAmount() {
    return this.dataService.paymentAmount;
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
    this.classSelected = this.dataService.paymentAmount !== 0;
    const url = 'http://13.126.191.183:8080/classAc/' + ReservationComponent.className;
    this.http.get(url).subscribe(
      (res: boolean) => {
        if (res) {
          this.ac = 'Yes';
        } else {
          this.ac = 'No';
        }
      }
    );
    const url1 = 'http://13.126.191.183:8080/seatsPerCabin/' + ReservationComponent.className;
    this.http.get(url1).subscribe(
      (res: string) => {
        this.seatsPerCabin = res;
      }
    );
    const url2 = 'http://13.126.191.183:8080/passengerPerSeat/' + ReservationComponent.className;
    this.http.get(url2).subscribe(
      (res: boolean) => {
        this.passengerPerSeat = res;
      }
    );
    const url3 = 'http://13.126.191.183:8080/luggageCapacity/' + ReservationComponent.className;
    this.http.get(url3).subscribe(
      (res: string) => {
        this.luggageCapacity = res;
      }
    );
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
        this.dataService.passengerDetails.classname = ReservationComponent.className;
        const url = 'http://13.126.191.183:8080/verifyClassAvailability/' + this.dataService.passengerDetails.classname;
        this.http.get(url).subscribe(
          (res: boolean) => {
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
      this.classSelected = false;
    }
}

  registerPassenger() {
      const url = 'http://13.126.191.183:8080/reservation';
      this.http.post<Classdetails>(url, this.dataService.passengerDetails).subscribe(
        res => {
          if (null != res) {
            this.dataService.passengerDetails = res;
            this.reservationSuccess = true;
            this.setPaymentAmount(this.dataService.passengerDetails.classname);
          } else {
            this.reservationSuccess = false;
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
    if (this.dataService.passengerDetails.passengerage.match('^[0]+$') ||
      !this.dataService.passengerDetails.passengerage.match('^[0-9]+$')) {
      this.validAge = false;
      return false;
    } else {
      this.validAge = true;
      return true;
    }
  }

  refresh() {
    PaymentComponent.paymentSuccess = false;
    this.ngOnInit();
  }
}
