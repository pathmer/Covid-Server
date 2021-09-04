import { TestBed } from '@angular/core/testing';

import { UsCountyDataService } from './us-county-data.service';

describe('UsCountyDataService', () => {
  let service: UsCountyDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsCountyDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
