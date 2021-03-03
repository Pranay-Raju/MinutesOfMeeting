import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { OrganizationComponent } from './organization/organization.component';
import { MemeberComponent } from './memeber/memeber.component';
import {  RouterModule, Routes } from '@angular/router';

import {HttpClientModule} from '@angular/common/http';

const routes: Routes = [
  {path:'',component:LoginComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OrganizationComponent,
    MemeberComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
