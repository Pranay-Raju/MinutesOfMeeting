import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/basic/login/login.component';
import { OrganizationComponent } from './components/admin/organization/organization.component';
import { RouterModule, Routes } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './components/basic/register/register.component';
import { NavbarComponent } from './components/basic/navbar/navbar.component';
import { ShowOrgMembersComponent } from './components/admin/show-org-members/show-org-members.component';
import { ShowOrgMeetingsComponent } from './components/facilitator/show-org-meetings/show-org-meetings.component';
import { HomePageComponent } from './components/basic/home-page/home-page.component';
// import { ShowHeadingsComponent } from './components/facilitator/show-headings/show-headings.component';
import { MemberGuard } from './guards/member.guard';
import { AdminGuard } from './guards/admin.guard';
import { FacilitatorGuard } from './guards/facilitator.guard';
// import { MemberByIdComponent } from './components/admin/member-by-id/member-by-id.component';
import { FooterComponent } from './components/basic/footer/footer.component';
import { AttendeesComponent } from './components/facilitator/attendees/attendees.component';
import { MomComponent } from './components/member/mom/mom.component';
import { HeadingComponent } from './components/facilitator/heading/heading.component';
import { SubHeadingComponent } from './components/facilitator/sub-heading/sub-heading.component';
import { PointComponent } from './components/facilitator/point/point.component';
// import { MomComponent } from './components/member/mom/mom.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegisterComponent },
  { path: 'showMembers', canActivate: [AdminGuard], component: ShowOrgMembersComponent },
  { path: 'showMeetings', canActivate: [FacilitatorGuard], component: ShowOrgMeetingsComponent },
  { path: 'mom', component: MomComponent },
  { path: 'showHeadings',  component: HeadingComponent },
  { path: 'showSubHeadings',  component: SubHeadingComponent },
  { path: 'showPoints',  component: PointComponent },
  // { path: 'mom', canActivate: [MemberGuard], component: MomComponent }


];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OrganizationComponent,
    RegisterComponent,
    NavbarComponent,
    ShowOrgMembersComponent,
    ShowOrgMeetingsComponent,
    HomePageComponent,
    // ShowHeadingsComponent,
    // MemberByIdComponent,
    FooterComponent,
    AttendeesComponent,
    MomComponent,
    HeadingComponent,
    SubHeadingComponent,
    PointComponent
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
