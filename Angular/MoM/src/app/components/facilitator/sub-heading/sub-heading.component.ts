import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SubHeadingService } from 'src/app/services/meeting&minutes/sub-heading.service';
import { HeadingService } from '../../../services/meeting&minutes/heading.service';

@Component({
  selector: 'app-sub-heading',
  templateUrl: './sub-heading.component.html',
  styleUrls: ['./sub-heading.component.css']
})
export class SubHeadingComponent implements OnInit {

  constructor(public headingService:HeadingService,public subheadingService:SubHeadingService,public router:Router) { }

  ngOnInit(): void {
  }
  editPoints(subHeading:any){
    this.subheadingService.subHeading = subHeading;
    console.log(subHeading);
    this.router.navigate(['showPoints']);


  }

}
