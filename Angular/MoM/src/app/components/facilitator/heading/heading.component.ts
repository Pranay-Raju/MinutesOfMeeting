import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeadingService } from '../../../services/meeting&minutes/heading.service';
import { MeetingService } from '../../../services/meeting&minutes/meeting.service';

@Component({
  selector: 'app-heading',
  templateUrl: './heading.component.html',
  styleUrls: ['./heading.component.css']
})
export class HeadingComponent implements OnInit {

  constructor(public meetService:MeetingService,public headingService:HeadingService,public router:Router) {

   }

  ngOnInit(): void {
  }

  editSubHeadings(heading:any){
    this.headingService.heading = heading;
    console.log(heading);
    this.router.navigate(['showSubHeadings']);


  }

}
