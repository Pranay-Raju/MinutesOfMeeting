import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(public regiserService: RegisterService) { }

  ngOnInit(): void {
  }
  registerForm(regForm: any) {
    console.log("Registration Form Details:");
    console.log(regForm);
    this.regiserService.registerOrg(regForm);


  }
}
