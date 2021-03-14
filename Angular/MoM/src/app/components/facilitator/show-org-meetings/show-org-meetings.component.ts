import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MeetingService } from 'src/app/services/meeting&minutes/meeting.service';
import { OrganizationService } from 'src/app/services/org&users/organization.service';

declare var jQuery: any;

@Component({
  selector: 'app-show-org-meetings',
  templateUrl: './show-org-meetings.component.html',
  styleUrls: ['./show-org-meetings.component.css']
})
export class ShowOrgMeetingsComponent implements OnInit {
  meetings: any
  editMeeting: any;
  editFlag: boolean;
  createFlag: boolean;
  faci: any;

  constructor(public meetingService: MeetingService, public orgService: OrganizationService, public router: Router) {
    this.editFlag = false;
    this.createFlag = false;
    this.meetings = [];
    this.editMeeting = {
      meetingId: '',
      name: '',
      facilitator: '',
      facilitatorName: '',
      startDateAndTime: '',
      endDateAndTime: ''
    };

  }

  ngOnInit(): void {
    this.loadMeetings();
  }

  async loadMeetings() {
    var t = await this.meetingService.getMeetings(this.orgService.organizationDetails.organizationId).toPromise();
    console.log("Meetings are");
    console.log(t);
    this.meetings = t;
    t = await this.orgService.getFacilitators();
    // console.log("Facilitators are ");
    // console.log(t);
    this.meetingService.setFacilitators(t);
  }

  ShowEditPopup(meeting: any) {
    this.editMeeting = meeting;
    this.editFlag = true;
    this.createFlag = false;
    jQuery('#empModel').modal('show');
  }
  async deleteMeeting(meeting: any) {
    console.log("deleting the meeting " + JSON.stringify(meeting));
    var t = await this.meetingService.deleteMeeting(meeting).toPromise();
    this.loadMeetings();
  }
  async createMeeting(meeting: any) {
    console.log(meeting);
    console.log(JSON.stringify(meeting.facilitator));
    var k: any;
    for (const iterator of this.meetingService.facilitators) {
      // console.log("iterator is " + iterator + "");
      if (iterator.name === meeting.facilitatorName) {
        k = iterator;
        // console.log("element is " + iterator);
      }
    }
    // console.log("k is " + JSON.stringify(k));
    meeting.facilitator = k;
    meeting.organization = this.orgService.organizationDetails;
    console.log(meeting);
    var t = await this.meetingService.createMeeting(meeting).toPromise();
    console.log(t);
    this.loadMeetings();
  }

  async updateMeeting(meeting: any) {
    console.log(meeting);
    console.log(JSON.stringify(meeting.facilitator));
    var k: any;
    for (const iterator of this.meetingService.facilitators) {
      // console.log("iterator is " + iterator + "");
      if (iterator.name === meeting.facilitatorName) {
        k = iterator;
        // console.log("element is " + iterator);
      }
    }
    // console.log("k is " + JSON.stringify(k));
    meeting.facilitator = k;
    meeting.organization = this.orgService.organizationDetails;
    console.log(meeting);
    var t = await this.meetingService.updateMeeting(meeting).toPromise();
    console.log(t);
    this.loadMeetings();
  }
  newMeeting() {
    this.createFlag = true;
    this.editFlag = false;
    jQuery('#empModel').modal('show');
  }

  editMinutes(meeting: any) {
    this.meetingService.meeting = meeting;
    console.log(meeting);
    this.router.navigate(['showHeadings']);
  }
  viewMinutes(meeting: any) {
    this.meetingService.meeting = meeting;
    console.log(meeting);
    this.router.navigate(['mom']);
  }

}