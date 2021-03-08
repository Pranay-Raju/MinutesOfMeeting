import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userLoggedIn: boolean;

  userRole: string;
  
  /*"admin" - >manage Members
    "facilitator" -> manage meetinggs and attendees
    "member" -> view Mom
  */

  user: any //all the user Data

  userRoles: any;

  constructor() {
    this.userLoggedIn = false;
    this.userRole = "user";
    this.userRoles = ["admin", "facilitator", "member"];
    this.user = {
      "name": "XYZ"
    }
  }

  getUserLoggedIn() {
    return this.userLoggedIn;
  }
  setUserLoggedIn(value: boolean) {
    this.userLoggedIn = value;
  }

  getUserRole() {
    return this.userRole;
  }
  setUserRole(value: string) {
    this.userRole = value;
  }

  getUser() {
    return this.user;
  }
  setUser(user: any) {
    this.user = user;
  }


}
