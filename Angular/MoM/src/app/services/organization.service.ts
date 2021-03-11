import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  organizationDetails:any;

  constructor(public httpClient:HttpClient) { }

  public getAllOrganizations(){
    return this.httpClient.get('allOrganizations');
  }

  public getOrganizationByName(name:string){
    return this.httpClient.get('org/byName/' + name);
  }

  getOrganizationDetails() {
    return this.organizationDetails;
  }
  setOrganizationDetails(value: any) {
    this.organizationDetails = value;
  }
}
