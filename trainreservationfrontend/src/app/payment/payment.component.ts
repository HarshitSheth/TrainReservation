import { Component, OnInit } from '@angular/core';
import {Paymentinformation} from '../../classes';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {DataServiceService} from '../data-service.service';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  static paymentSuccess = false;
  validCardNumber = true;
  validExpiryMonth = true;
  validExpiryYear = true;
  validCvv = true;
  validName = true;
  verification = false;
  cardnumber = '';
  expirymonth = '';
  expiryyear = '';
  cvv = '';

  constructor(private http: HttpClient, private router: Router, private dataService: DataServiceService, private app: AppComponent) { }

  paymentInfo: Paymentinformation = {
    cardholdername: '', paymentamount: this.dataService.paymentAmount,
  };

  ngOnInit() {
  }

  verifyLogin(): boolean {
    if (null != sessionStorage.getItem('userData')) {
      if (null != sessionStorage.getItem('reservationProcess')) {
        return true;
      } else {
        this.router.navigate(['http://13.126.191.183:8080/reservation']);
      }
    } else {
      this.router.navigate(['http://13.126.191.183:8080/login']);
    }
  }

  payment() {
    this.validCardNumber = this.validateCardNumber();
    this.validExpiryMonth = this.validateExpiryMonth();
    this.validExpiryYear = this.validateExpiryYear();
    this.validCvv = this.validateCvv();
    this.validName = this.validateName();

    if (!this.validateCardNumber() || !this.validExpiryMonth || !this.validExpiryYear || !this.validCvv || !this.validName) {
      this.verification = false;
      PaymentComponent.paymentSuccess = false;
      return;
    } else {
      this.verification = true;
    }

    if (this.verification) {
      const url = 'http://13.126.191.183:8080/payment';
      this.http.post<boolean>(url, this.paymentInfo).subscribe(
        res => {
          if (res) {
            console.log('payment successful');
            PaymentComponent.paymentSuccess = true;
            this.router.navigate(['reservation']);
          } else {
            console.log('payment false');
            PaymentComponent.paymentSuccess = false;
            return;
          }
        }
      );
    }
  }

  validateCardNumber(): boolean {
    if (!this.cardnumber.match('^[0-9]{16}$') || this.cardnumber.match('^[0]{16}$')) {
      return false;
    } else {
      return true;
    }
  }

  validateExpiryMonth(): boolean {
    if (!this.expirymonth.match('^(0?[1-9]|1[012])$')) {
      return false;
    } else {
      return true;
    }
  }

  validateExpiryYear(): boolean {
    if (!this.expiryyear.match('^20\\d{2}$')) {
      return false;
    } else {
      return true;
    }
  }

  validateCvv(): boolean {
    if (!this.cvv.match('^[0-9]{3}$')) {
      return false;
    } else {
      return true;
    }
  }

  validateName(): boolean {
    if (!this.paymentInfo.cardholdername.match('^[a-zA-Z]+(\\s[a-zA-Z]+)*$')) {
      return false;
    } else {
      return true;
    }
  }
}
