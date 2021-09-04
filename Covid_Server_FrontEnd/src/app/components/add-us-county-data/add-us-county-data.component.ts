import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { HttpClient } from "@angular/common/http";

import { UsCountyDataService } from '../../services/us-county-data.service';
import { US_County_Data } from '../../interfaces/US_County_Data';

@Component({
  selector: 'app-add-us-county-data',
  templateUrl: './add-us-county-data.component.html',
  styleUrls: ['./add-us-county-data.component.css']
})
export class AddUsCountyDataComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private UsCountyDataService: UsCountyDataService,
    private location: Location,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
  }


  getUS_County_Data() {
    this.UsCountyDataService.addAllUS_County_Data().subscribe(
      uscountydata => {
        console.log(uscountydata);
      },
      error => {
        console.log(error);
      }
    )
  }
}

