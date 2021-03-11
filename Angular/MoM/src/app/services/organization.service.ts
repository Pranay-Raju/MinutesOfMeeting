import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  organizationDetails:any;

  constructor(public httpClient:HttpClient) { }



  getOrganizationDetails() {
    return this.organizationDetails;
  }
  setOrganizationDetails(value: any) {
    this.organizationDetails = value;
  }
}
