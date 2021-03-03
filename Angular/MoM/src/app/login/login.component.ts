import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: any;
  constructor() { 
    this.user = {loginId:'', password:''};

  }

  ngOnInit(): void {
  }
  

  submitLoginForm(loginForm: any): void {
    console.log("LoginForm Object Data : ");
    console.log(loginForm);
  }

}
