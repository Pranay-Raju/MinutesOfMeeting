import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public user:any;

  constructor(public service:LoginService) { 
  }

  ngOnInit(): void {
    this.user = this.service.user;
  }

}
