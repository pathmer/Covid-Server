import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

// import { CookieService } from 'ngx-cookie-service';
import { SandboxpageComponent } from './components/sandboxpage/sandboxpage.component';
import { AppRoutingModule } from './app-routing.module';
import { ViewUsCountiesComponent } from './components/view-us-counties/view-us-counties.component';
import { AddUsCountiesComponent } from './components/add-us-counties/add-us-counties.component';
import { AddUsCasesDeathsComponent } from './components/add-us-cases-deaths/add-us-cases-deaths.component';
import { AddUsCountyDataComponent } from './components/add-us-county-data/add-us-county-data.component';


@NgModule({
  declarations: [
    AppComponent,
    SandboxpageComponent,
    ViewUsCountiesComponent,
    AddUsCountiesComponent,
    AddUsCasesDeathsComponent,
    AddUsCountyDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  // providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
