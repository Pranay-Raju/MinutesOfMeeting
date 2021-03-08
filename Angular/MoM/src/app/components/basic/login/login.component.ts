import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../../services/login.service';
import { delay } from 'rxjs/operators';
import { NavbarComponent } from '../navbar/navbar.component';
import { UserService } from '../../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  invalidMessage: any;


  constructor(public loginService: LoginService, public userService: UserService,public router:Router) {

  }

  ngOnInit(): void {
  }


  async submitLoginForm(loginForm: any) {
    console.log("LoginForm Object Data : ");
    console.log(loginForm);

    const t = await this.loginService.loginAsUser(loginForm).pipe(delay(1000)).toPromise();

    console.log('the user is ' + JSON.stringify(t));
    if (t === null || typeof t === undefined || t.memberId === 0) {
      this.loginService.user = { name: "XYZ" };
      this.invalidMessage = "InvalidCredentials";
    }
    else {
      this.loginService.user = t;
      this.userService.setUserLoggedIn(true);
      this.userService.setUser(t);
      this.userService.setUserRole(t.role);
      if(t.role === "admin"){
      this.router.navigate(['showMembers']);
    }
    else if(t.role ==="facilitator"){
      this.router.navigate(['showMeetings']);
    }
    else if(t.role === "member"){
      this.router.navigate(['showHeadings'])
    }
    }
  }

}
