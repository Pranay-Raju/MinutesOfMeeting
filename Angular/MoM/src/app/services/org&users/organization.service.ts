import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
/**
 * Service to manage organization details based on the logedIn user
 */
export class OrganizationService {

  organizationDetails: any;

  constructor(public httpClient: HttpClient) { }



  getOrganizationDetails() {
    return this.organizationDetails;
  }
  setOrganizationDetails(value: any) {
    this.organizationDetails = value;
  }

  getFacilitators(){
    return this.httpClient.get("allFacilitators/" + this.organizationDetails.organizationId).toPromise();
  }
}
