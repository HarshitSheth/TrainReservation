import { Component, OnInit } from '@angular/core';
import {Classdetails} from '../../classes';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

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

  public fetchPassenger(pnr): PassengerDetailsComponent {
    if (this.validatePnr()) {
      this.verification = true;
      const url = 'http://192.168.33.10:8080/passengerDetails';
      this.http.post<Classdetails>(url, pnr).subscribe(
        res => {
          if (null != res && null != res.passengername) {
            this.passengerDetails = res;
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
