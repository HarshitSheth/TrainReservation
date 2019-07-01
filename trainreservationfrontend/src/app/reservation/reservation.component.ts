import { Component, OnInit } from '@angular/core';
import {ClassChoiceComponent} from '../class-choice/class-choice.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  classChoice: string;
  classIsSelected = false;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  verifyLogin(): boolean {
    if (null != sessionStorage.getItem('userData')) {
      return true;
    } else {
      this.router.navigate(['/login']);
    }
  }

  classSelect($event: any) {
    ClassChoiceComponent.availability = true;
    ClassChoiceComponent.validName = true;
    ClassChoiceComponent.validAge = true;
    ClassChoiceComponent.verification = false;
    ClassChoiceComponent.className = $event.target.value;
    this.classChoice = $event.target.value;
    this.classIsSelected = true;
  }
}
