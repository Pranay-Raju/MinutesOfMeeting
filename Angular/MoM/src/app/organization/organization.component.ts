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

  registerOrganization(regForm: any) {
    console.log("Org Registration Details:");
    console.log(regForm);


  }

}
