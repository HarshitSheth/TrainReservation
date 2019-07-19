import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  springBoot = 'http://locahhost:8080';
  title = 'Welcome to Train Reservation!';
}

