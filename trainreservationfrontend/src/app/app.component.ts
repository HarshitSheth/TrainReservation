import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  springBoot = 'http://localhost:8081';
  title = 'Welcome to Train Reservation!';
}

