import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-memeber',
  templateUrl: './memeber.component.html',
  styleUrls: ['./memeber.component.css']
})
export class MemeberComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  
registerMember(regForm: any) {
  console.log("Member Registration Details:");
  console.log(regForm); 


}

}
