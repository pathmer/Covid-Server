import { TestBed } from '@angular/core/testing';

import { UsCountiesService } from './us-counties.service';

describe('UsCountiesService', () => {
  let service: UsCountiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsCountiesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
