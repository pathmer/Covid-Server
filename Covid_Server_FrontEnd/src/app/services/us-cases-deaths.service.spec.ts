import { TestBed } from '@angular/core/testing';

import { UsCasesDeathsService } from './us-cases-deaths.service';

describe('UsCasesDeathsService', () => {
  let service: UsCasesDeathsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsCasesDeathsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
