import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './components/profile/profile.component';
import {CompanyComponent} from './components/company/company.component';
import { SearchForCompanyComponent } from './components/search-for-company/search-for-company.component';
import {FormsModule} from '@angular/forms';
import {DataService} from './services/data.service';
import {PersonComponent} from './components/person/person.component';
import { SectorComponent } from './components/sector/sector.component';
import { AddressComponent } from './components/address/address.component';
import { StockCodeComponent } from './stock-code/stock-code.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProfileComponent,
    CompanyComponent,
    SearchForCompanyComponent,
    PersonComponent,
    SectorComponent,
    AddressComponent,
    StockCodeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
