import { US_County } from './US_County';

export class US_Cases_Deaths {
    id?: number;
    thedate: Date;
    county: string;
    state: string;
    fips: number;
    cases: number;
    deaths: number;
    us_counties: US_County;

    constructor(thedate: Date, county: string, state: string, fips: number, cases: number, deaths: number, us_counties: US_County){
        this.thedate = thedate;
        this.county = county;
        this.state = state;
        this.fips = fips;
        this.cases = cases;
        this.deaths = deaths;
        this.us_counties = us_counties;
      }
}
