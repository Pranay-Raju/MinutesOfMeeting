import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class MemberGuard implements CanActivate {

  constructor(public userService:UserService){

  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return (this.userService.getUserLoggedIn()=== true) && ((this.userService.getUserRole() === "admin")|| (this.userService.getUserRole() === "facilitator") || (this.userService.getUserRole() === "member"));
  }
  
}
