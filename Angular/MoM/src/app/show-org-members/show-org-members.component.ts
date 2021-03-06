import { Component, OnInit } from '@angular/core';
import { OrganizationService } from '../organization.service';

@Component({
  selector: 'app-show-org-members',
  templateUrl: './show-org-members.component.html',
  styleUrls: ['./show-org-members.component.css']
})
export class ShowOrgMembersComponent implements OnInit {

  members: any;

  orgMembers: any;

  // organization: any;
  organizationId: any;
  organizations: any;

  constructor(public organizationService:OrganizationService) {

    this.members = [
      {
        memberId: 1, name: 'Tejaswini', organisation: 'TalentSprint', mailId: 'tejaswini@gmail.com', mobileNo: 957114125, role: 'admin',
        address: 'Rjy', gender: 'F', loginId: 'teju123', password: 'password'
      },
      {
        memberId: 2, name: 'Pranay', organisation: 'TalentSprint', mailId: 'pranay@gmail.com', mobileNo: 957458516, role: 'Facilitator',
        address: 'Hyd', gender: 'M', loginId: 'pranay123', password: 'password'
      },
      {
        memberId: 3, name: 'Rakesh', organisation: 'TalentSprint', mailId: 'rakesh@gmail.com', mobileNo: 805114125, role: 'Member',
        address: 'sec', gender: 'M', loginId: 'rakesh123', password: 'password'
      },
      {
        memberId: 4, name: 'Navya', organisation: 'TalentSprint', mailId: 'navya@gmail.com', mobileNo: 896744125, role: 'Member',
        address: 'Kkd', gender: 'F', loginId: 'navya123', password: 'password'
      },
      {
        memberId: 5, name: 'Gayathri', organisation: 'TalentSprint', mailId: 'gayathri@gmail.com', mobileNo: 45714125, role: 'Member',
        address: 'vzg', gender: 'M', loginId: 'gayathri123', password: 'password'
      },
      {
        memberId: 6, name: 'Lavanya', organisation: 'TalentSprint', mailId: 'lavanya@gmail.com', mobileNo: 68944125, role: 'Member',
        address: 'Sec', gender: 'F', loginId: 'lavanya123', password: 'password'
      }
    ]
    organizationService.getAllOrganizations().subscribe((data:any)=> {console.log(data), this.organizations = data;});
  }

  ngOnInit(): void {
  }

  getEmpById(orgId:any){
    console.log("Will fetch org with ID " + orgId);

  }

  showEditPop(){

  }

}