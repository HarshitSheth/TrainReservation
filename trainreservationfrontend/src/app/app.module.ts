import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { GlobalMenuComponent } from './global-menu/global-menu.component';
import { RouterModule, Routes} from '@angular/router';
import { ReservationComponent } from './reservation/reservation.component';
import { CancellationComponent } from './cancellation/cancellation.component';
import { AvailabilityComponent } from './availability/availability.component';
import { PassengerDetailsComponent } from './passenger-details/passenger-details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
// import { ClassChoiceComponent } from './class-choice/class-choice.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { PaymentComponent } from './payment/payment.component';


const appRoutes: Routes = [
  {path: 'login',
    component: LoginComponent},
  {path: 'register',
    component: RegisterComponent},
  {path: 'reservation',
    component: ReservationComponent},
  {path: 'passengerDetails',
    component: PassengerDetailsComponent},
  {path: 'cancelReservation',
    component: CancellationComponent},
  {path: 'classAvailability',
    component: AvailabilityComponent},
  {path: 'logout',
    component: LogoutComponent},
  {path: 'payment',
    component: PaymentComponent},
  {path: '',
    component: HomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    GlobalMenuComponent,
    GlobalMenuComponent,
    ReservationComponent,
    CancellationComponent,
    AvailabilityComponent,
    PassengerDetailsComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    // ClassChoiceComponent,
    HomeComponent,
    PaymentComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes, {useHash: true}),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {

}
