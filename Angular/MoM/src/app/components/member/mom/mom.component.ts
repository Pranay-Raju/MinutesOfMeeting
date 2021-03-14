import { Component, OnInit } from '@angular/core';
import { MeetingService } from '../../../services/meeting&minutes/meeting.service';
import { MemberService } from '../../../services/org&users/member.service';

@Component({
  selector: 'app-mom',
  templateUrl: './mom.component.html',
  styleUrls: ['./mom.component.css']
})
export class MomComponent implements OnInit {

  constructor(public meetService:MeetingService) { 
    console.log("in meeting srcie");
    console.log(meetService.meeting);
  }

  ngOnInit(): void {
  }

}
