import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Classdetails} from '../../classes';
import {Router} from '@angular/router';

@Component({
  selector: 'app-class-choice',
  templateUrl: './class-choice.component.html',
  styleUrls: ['./class-choice.component.css']
})
export class ClassChoiceComponent implements OnInit {

  static className: string;
  static validName = true;
  static validAge = true;
  static availability = true;
  static verification = false;
  passengerDetails: Classdetails = {
    classname: '', coach: '', pnr: '', seatnumber: '',
    passengername: '',
    passengerage: '',
  };

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  verifyLogin(): boolean {
    if (null != sessionStorage.getItem('userData')) {
      return true;
    } else {
      this.router.navigate(['/login']);
    }
  }

  get validName() {
    return ClassChoiceComponent.validName;
  }

  get validAge() {
    return ClassChoiceComponent.validAge;
  }

  get availability() {
    return ClassChoiceComponent.availability;
  }

  get verification() {
    return ClassChoiceComponent.verification;
  }

  registerPassenger(): void {
    if (!this.validateAge()) {
      if (!this.validateName()) {
        ClassChoiceComponent.verification = false;
        return;
      }
    } else {
      if (!this.validateName()) {
        ClassChoiceComponent.verification = false;
        return;
      } else {
        ClassChoiceComponent.verification = true;
      }
    }
    if (this.verification) {
      const url = 'http://localhost:8080/reservation';
      this.passengerDetails.classname = ClassChoiceComponent.className;
      this.http.post<Classdetails>(url, this.passengerDetails).subscribe(
        res => {
          if (null != res) {
            ClassChoiceComponent.availability = true;
            this.passengerDetails = res;
          } else {
            ClassChoiceComponent.availability = false;
            return;
          }
        }
      );
    }
  }

  validateName(): boolean {
    if (!this.passengerDetails.passengername.match('^[a-zA-Z]+(\\s[a-zA-Z]+)*$')) {
      ClassChoiceComponent.validName = false;
      return false;
    } else {
      ClassChoiceComponent.validName = true;
      return true;
    }
  }

  validateAge(): boolean {
    if (!this.passengerDetails.passengerage.match('^[0-9]+$')) {
      ClassChoiceComponent.validAge = false;
      return false;
    } else {
      ClassChoiceComponent.validAge = true;
      return true;
    }
  }
}
