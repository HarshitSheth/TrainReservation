import { Injectable } from '@angular/core';
import {Classdetails} from '../classes';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  paymentAmount = 0;

  passengerDetails: Classdetails = {
      classname: '', coach: '', pnr: '', seatnumber: '',
      passengername: '',
      passengerage: '',
    };
  obj2: Classdetails;

  constructor() { }

}
