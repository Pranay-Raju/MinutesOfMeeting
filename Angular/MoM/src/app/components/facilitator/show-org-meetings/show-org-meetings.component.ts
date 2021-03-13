import { Component, OnInit } from '@angular/core';
import { MeetingService } from 'src/app/services/meeting.service';
import { OrganizationService } from 'src/app/services/organization.service';

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

  constructor(public meetingService: MeetingService, public orgService: OrganizationService) {
    this.editFlag = false;
    this.createFlag = false;
    this.meetings = [];
    //     {
    //       "id": 3,
    //       "meetingName": "Work Plan for Day2",
    //       "organizationName": "Talent Sprint",
    //       "facilitator": {
    //           "memberId": 3,
    //           "name": "Gayathri",
    //           "organizationName": "Talent Sprint",
    //           "mobileNo": null,
    //           "role": "facilitator",
    //           "address": "",
    //           "gender": "",
    //           "loginId": "gaya123",
    //           "password": "password"
    //       },
    //       "startDateAndTime": null,
    //       "endDateAndTime": null,
    //       "attendees": [],
    //       "headings": []
    //   },
    //   {
    //     "id": 3,
    //     "meetingName": "Work Plan for Day3",
    //     "organizationName": "Talent Sprint",
    //     "facilitator": {
    //         "memberId": 3,
    //         "name": "Navya",
    //         "organizationName": "Talent Sprint",
    //         "mobileNo": null,
    //         "role": "facilitator",
    //         "address": "",
    //         "gender": "",
    //         "loginId": "gaya123",
    //         "password": "password"
    //     },
    //     "startDateAndTime": null,
    //     "endDateAndTime": null,
    //     "attendees": [],
    //     "headings": []
    // }
    // { meetingId: 1, meetingName: 'Project', facilitator: 'harsha', startDateAndTime: '12Feb 8:00Am', endDateAndTime: '12Feb 9:00Am' },
    // { meetingId: 2, meetingName: 'Navya', facilitator: 'pasha', startDateAndTime: '12Feb 9:00Am', endDateAndTime: '12Feb 10:00Am' },
    // { meetingId: 3, meetingName: 'lavanya', facilitator: 'pranay', startDateAndTime: '13Feb 8:00Am', endDateAndTime: '13Feb 9:00Am' },
    // { meetingId: 4, meetingName: 'Tejaswini', facilitator: 'harsha', startDateAndTime: '14Feb 8:00Am', endDateAndTime: '14Feb 9:00Am' },
    // { meetingId: 5, meetingName: 'Rakesh', facilitator: 'rakesh', startDateAndTime: '15Feb 8:00Am', endDateAndTime: '15Feb 9:00Am' },
    // { meetingId: 6, meetingName: 'pranay', facilitator: 'harsha', startDateAndTime: '16Feb 8:00Am', endDateAndTime: '16Feb 9:00Am' }
    // ]
    this.editMeeting = {
      meetingId: '', meetingName: '', facilitator: {
        "address": "",
        "gender": "",
        "loginId": "gaya123",
        "memberId": 3,
        "mobileNo": null,
        "name": "Gayathri",
        "organizationName": "Talent Sprint",
        "password": "password",
        "role": "facilitator"
      }, startDateAndTime: '', endDateAndTime: ''
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
    console.log("Facilitators are ");
    console.log(t);
    this.meetingService.setFacilitators(t);
  }

  ShowEditPopup(meeting: any) {
    this.editMeeting = meeting;
    this.editFlag = true;
    this.createFlag = false;
    jQuery('#empModel').modal('show');
  }
  deleteMeeting(meeting: any) {

  }
  updateMeeting(meeting: any) {
    console.log(meeting);
  }
  newMeeting() {
    this.createFlag = true;
    this.editFlag = false;
    jQuery('#empModel').modal('show');
  }

}