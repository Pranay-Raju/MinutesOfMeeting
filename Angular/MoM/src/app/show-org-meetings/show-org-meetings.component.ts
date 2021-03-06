import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-org-meetings',
  templateUrl: './show-org-meetings.component.html',
  styleUrls: ['./show-org-meetings.component.css']
})
export class ShowOrgMeetingsComponent implements OnInit {
  meetings:any;

  constructor() {
    this.meetings=[
      {meetingId:1, name:'Gayathri'},{meetingId:2, name:'Navya'},{meetingId:3, name:'lavanya'},{meetingId:4, name:'Tejaswini'},{meetingId:5, name:'Rakesh'},{meetingId:6, name:'pranay'}
      
      
     
    ]


   }

  ngOnInit(): void {
  }
  ShowEditPopup(meeting : any){

  }
  deleteMeeting(meeting : any){

  }

}