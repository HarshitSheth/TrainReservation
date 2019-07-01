import { Component, OnInit } from '@angular/core';
import {ClassChoiceComponent} from '../class-choice/class-choice.component';
import {HttpClient} from '@angular/common/http';
import {Classinformation} from '../../classes';
import {Router} from '@angular/router';

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

  constructor(private http: HttpClient, private router: Router) { }

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
    ClassChoiceComponent.className = $event.target.value;
    this.classChoice = $event.target.value;
    this.classIsSelected = true;
    const url = 'http://localhost:8080/getAvailability';
    this.http.post<Classinformation>(url, ClassChoiceComponent.className).subscribe(
      res => {
        this.classinfo = res;
      },
    );
  }
}
