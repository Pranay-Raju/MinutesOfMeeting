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
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ShowOrgMembersComponent } from './show-org-members/show-org-members.component';
import { ShowOrgMeetingsComponent } from './show-org-meetings/show-org-meetings.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  {path:'',component:HomePageComponent},
  {path:'login',component:LoginComponent},
  {path:'registration',component:RegisterComponent},
  {path:'showMembers',component:ShowOrgMembersComponent},
  {path:'showMeetings',component:ShowOrgMeetingsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OrganizationComponent,
    MemeberComponent,
    RegisterComponent,
    NavbarComponent,
    ShowOrgMembersComponent,
    ShowOrgMeetingsComponent,
    HomePageComponent
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
