import { US_County } from './US_County';

export class US_County_Data {
    id?: number;
    thedate: Date;
    fips: number;
    active_cases: number;
    active_cases_week: number;
    deaths_week: number;
    active_cases_permil: number;
    active_cases_week_permil: number;
    deaths_permil: number;
    deaths_week_permil: number;
    us_counties: US_County;

    constructor(thedate: Date, fips: number, active_cases: number, active_cases_week: number,
        deaths_week: number, active_cases_permil: number, active_cases_week_permil: number,
        deaths_permil: number, deaths_week_permil: number, us_counties: US_County){
        
        this.thedate = thedate;
        this.fips = fips;
        this.active_cases = active_cases;
        this.active_cases_week = active_cases_week;
        this.deaths_week = deaths_week;
        this.active_cases_permil = active_cases_permil;
        this.active_cases_week_permil = active_cases_week_permil;
        this.deaths_permil = deaths_permil;
        this.deaths_week_permil = deaths_week_permil;
        this.us_counties = us_counties;
      }
}
