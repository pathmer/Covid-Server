import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { HttpClient } from "@angular/common/http";

import { UsCasesDeathsService } from '../../services/us-cases-deaths.service';
import { US_Cases_Deaths } from '../../interfaces/US_Cases_Deaths';

@Component({
  selector: 'app-add-us-cases-deaths',
  templateUrl: './add-us-cases-deaths.component.html',
  styleUrls: ['./add-us-cases-deaths.component.css']
})
export class AddUsCasesDeathsComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private UsCasesDeathsService: UsCasesDeathsService,
    private location: Location,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
  }


  getUS_Cases_Deaths() {
    this.UsCasesDeathsService.addAllUS_Cases_Deaths().subscribe(
      uscasesdeaths => {
        console.log(uscasesdeaths);
      },
      error => {
        console.log(error);
      }
    );
  }
}
