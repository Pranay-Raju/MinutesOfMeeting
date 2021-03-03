import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-organization',
  templateUrl: './organization.component.html',
  styleUrls: ['./organization.component.css']
})
export class OrganizationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  registeruser(regForm: any) {
    console.log("User Registration Details:");
    console.log(regForm);


  }

}
