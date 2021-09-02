
export class US_County {
    id?: number;
    fips: number;
    state: string;
    county: string;
    population: number;

    constructor(fips: number, state: string, county: string, population: number){
        this.fips = fips;
        this.state = state;
        this.county = county;
        this.population = population;
      }
}