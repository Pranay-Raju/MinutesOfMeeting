import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../../../services/register.service';
import { UserService } from '../../../services/user.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerSuccessMsg:any;
  userRoles:any

  constructor(public regiserService: RegisterService,public userService:UserService) { 
    this.userRoles = userService.userRoles;
  }

  ngOnInit(): void {
  }
  registerForm(regForm: any) {
    console.log("Registration Form Details:");
    console.log(regForm);
    const t = this.regiserService.registerOrg(regForm);
    this.registerSuccessMsg = "Registration Successful";
    // this.router.navigate()
    console.log(t);
  }
}
