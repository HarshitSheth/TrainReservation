import { Component, OnInit } from '@angular/core';
// import {ClassChoiceComponent} from '../class-choice/class-choice.component';
import {HttpClient} from '@angular/common/http';
import {Classinformation} from '../../classes';
import {Router} from '@angular/router';
import {ReservationComponent} from '../reservation/reservation.component';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-availability',
  templateUrl: './availability.component.html',
  styleUrls: ['./availability.component.css']
})
export class AvailabilityComponent implements OnInit {

  classChoice: string;
  classIsSelected = false;
  // classAvailability: number;

  classinfo: Classinformation = {
    classname: '', availability: '', totalseats: ''
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

  classSelect($event: any) {
    ReservationComponent.className = $event.target.value;
    this.classChoice = $event.target.value;
    const url = 'http://13.126.191.183:8080/getAvailability';
    this.http.post<Classinformation>(url, ReservationComponent.className).subscribe(
      res => {
        this.classIsSelected = true;
        this.classinfo = res;
      },
    );
  }
}
