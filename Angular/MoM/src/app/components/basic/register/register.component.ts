import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../../../services/register.service';
import { UserService } from '../../../services/user.service';

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
    this.regiserService.registerOrg(regForm);
    this.registerSuccessMsg = "Registration Successful";

  }
}
