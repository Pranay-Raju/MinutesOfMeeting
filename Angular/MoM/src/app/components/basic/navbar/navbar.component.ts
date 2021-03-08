import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { LoginService } from '../../../services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public user:any;
  public userRole:any;

  constructor(public service:UserService) { 
  }

  ngOnInit(): void {
    this.user = this.service.user;
    this.userRole = this.service.userRole;
    console.log('Nav bar user is ' + this.user);
  }

}
