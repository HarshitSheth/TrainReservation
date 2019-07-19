import { Component, OnInit } from '@angular/core';
import {Classdetails} from '../../classes';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-passenger-details',
  templateUrl: './passenger-details.component.html',
  styleUrls: ['./passenger-details.component.css']
})
export class PassengerDetailsComponent implements OnInit {

  verification = false;
  validPnr = true;
  public passengerDetails: Classdetails = {
    classname: '', coach: '', pnr: '', seatnumber: '',
    passengername: '',
    passengerage: '',
  };

  constructor(private http: HttpClient, private router: Router, private app: AppComponent) { }

  ngOnInit() {
  }

  verifyLogin(): boolean {
    if (null != sessionStorage.getItem('userData')) {
      return true;
    } else {
      this.router.navigate(['login']);
    }
  }

  public fetchPassenger(pnr): PassengerDetailsComponent {
    if (this.validatePnr()) {
      const url = 'http://13.126.191.183:8080/passengerDetails';
      this.http.post<Classdetails>(url, pnr).subscribe(
        res => {
          if (null != res && null != res.passengername) {
            this.passengerDetails = res;
            this.verification = true;
            return this.passengerDetails;
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
  }

  validatePnr(): boolean {
    if (!this.passengerDetails.pnr.match('^[0-9]+$')) {
      this.validPnr = false;
      return false;
    } else {
      this.validPnr = true;
      return true;
    }
  }
}
