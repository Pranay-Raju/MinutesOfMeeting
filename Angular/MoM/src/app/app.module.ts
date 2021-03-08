import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/basic/login/login.component';
import { OrganizationComponent } from './components/admin/organization/organization.component';
import { MemeberComponent } from './components/admin/memeber/memeber.component';
import { RouterModule, Routes } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './components/basic/register/register.component';
import { NavbarComponent } from './components/basic/navbar/navbar.component';
import { ShowOrgMembersComponent } from './components/admin/show-org-members/show-org-members.component';
import { ShowOrgMeetingsComponent } from './components/facilitator/show-org-meetings/show-org-meetings.component';
import { HomePageComponent } from './components/basic/home-page/home-page.component';
import { ShowHeadingsComponent } from './components/member/show-headings/show-headings.component';
import { MemberGuard } from './guards/member.guard';
import { AdminGuard } from './guards/admin.guard';
import { FacilitatorGuard } from './guards/facilitator.guard';
import { MemberByIdComponent } from './components/admin/member-by-id/member-by-id.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegisterComponent },
  { path: 'showMembers', canActivate: [AdminGuard], component: ShowOrgMembersComponent },
  { path: 'memberReg', canActivate: [AdminGuard], component: MemeberComponent },
  { path: 'showMeetings', canActivate: [FacilitatorGuard], component: ShowOrgMeetingsComponent },
  { path: 'showHeadings', canActivate: [MemberGuard], component: ShowHeadingsComponent }


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
    HomePageComponent,
    ShowHeadingsComponent,
    MemberByIdComponent
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
