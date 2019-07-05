import { Component, OnInit } from '@angular/core';
import {Userinformation} from '../../classes';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  validName = true;
  validEmail = true;
  validContact = true;
  validUserName = true;
  validPassword = true;
  validConfirmPass = true;
  availableUser = true;

  confirmpassword = '';

  registerUser: Userinformation = {
    name: '', email: '', contact: '', username: '', password: ''
  };

  constructor(public router: Router, private http: HttpClient) {}

  ngOnInit() {
  }

  logOut(): boolean {
    if (null != sessionStorage.getItem('userData')) {
      return false;
    } else {
      return true;
    }
}

  register() {
    this.validName = this.validateName();
    this.validEmail = this.validateEmail();
    this.validContact = this.validateContact();
    this.validUserName = this.validateUsername();
    this.validPassword = this.validatePassword();
    this.validConfirmPass = this.validateConfirmPassword();
    this.userNameAvailability();


  }

  execute() {
    if (!this.validName || !this.validEmail || !this.validContact || !this.validUserName ||
      !this.validPassword || !this.validConfirmPass || !this.availableUser) {
      return;
    } else {
      const url = 'http://192.168.33.10:8080/register';
      this.http.post<boolean>(url, this.registerUser).subscribe(
        res => {
          if (res) {
            this.router.navigate(['login']);
          } else {
            return;
          }
        }
      );
    }
  }

  userNameAvailability() {
    const url = 'http://192.168.33.10:8080/usernameAvailability';
    this.http.post<boolean>(url, this.registerUser.username).subscribe(
      res => {
        if (!res) {
          this.availableUser = false;
        } else {
          this.availableUser = true;
        }
        this.execute();
      }
    );
  }

  validateName(): boolean {
    if (!this.registerUser.name.match('^[a-zA-Z]+(\\s[a-zA-Z]+)*$')) {

      return false;
    } else {
      // this.validName = true;
      return true;
    }
  }

  validateEmail(): boolean {
    if (!this.registerUser.email.match('^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$')) {

      return false;
    } else {
      // this.validEmail = true;
      return true;
    }
  }

  validateContact(): boolean {
    if (!this.registerUser.contact.match('^[6-9]\\d{9}$')) {

      return false;
    } else {
      // this.validContact = true;
      return true;
    }
  }

  validateUsername(): boolean {
    if (!this.registerUser.username.match('^[a-zA-Z0-9]+$')) {

      return false;
    } else {
      // this.validName = true;
      return true;
    }
  }

  validatePassword(): boolean {
    if (!this.registerUser.password.match('^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})$')) {
      return false;
    } else {
      // this.validPassword = true;
      return true;
    }
  }

  validateConfirmPassword(): boolean {
    if (!(this.registerUser.password === this.confirmpassword) ||
      !(this.confirmpassword.match('^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})$'))) {

      return false;
    } else {
      // this.validConfirmPass = true;
      return true;
    }
  }

  goToLogout() {
    this.router.navigate(['logout']);
  }
}
