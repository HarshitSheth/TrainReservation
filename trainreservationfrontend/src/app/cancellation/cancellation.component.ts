import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {PassengerDetailsComponent} from '../passenger-details/passenger-details.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cancellation',
  providers: [PassengerDetailsComponent],
  templateUrl: './cancellation.component.html',
  styleUrls: ['./cancellation.component.css']
})
export class CancellationComponent implements OnInit {

  verification = false;
  validPnr = true;
  pnr = '';
  message: string = null;
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  verifyLogin(): boolean {
    if (null != sessionStorage.getItem('userData')) {
      return true;
    } else {
      this.router.navigate(['login']);
    }
  }

  cancelReservation(): void {
    if (this.validatePnr()) {
      this.verification = true;
      // this.details = this.passengerDetails.fetchPassenger(this.pnr);
      // if (this.confirmCancellation()) {
      const url = 'http://192.168.33.10:8080/cancelReservation';
      this.http.post<boolean>(url, this.pnr).subscribe(
        res => {
          if (res) {
            this.message = 'Reservation with PNR ' + this.pnr + ' is cancelled';
          } else {
            this.validPnr = false;
            this.verification = false;
            return;
          }
        },
      );
    } else {
      return;
    }
    // } else {
    //   return;
    // }
  }

  // confirmCancellation(): boolean {
  //   this.confirmation =  true;
  //   return true;
  // }

  validatePnr(): boolean {
    if (!this.pnr.match('^[0-9]+$')) {
      this.validPnr = false;
      return false;
    } else {
      this.validPnr = true;
      return true;
    }
  }
}
