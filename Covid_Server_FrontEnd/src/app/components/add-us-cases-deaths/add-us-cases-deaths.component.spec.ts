import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUsCasesDeathsComponent } from './add-us-cases-deaths.component';

describe('AddUsCasesDeathsComponent', () => {
  let component: AddUsCasesDeathsComponent;
  let fixture: ComponentFixture<AddUsCasesDeathsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUsCasesDeathsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUsCasesDeathsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
