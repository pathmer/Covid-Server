import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUsCountyDataComponent } from './add-us-county-data.component';

describe('AddUsCountyDataComponent', () => {
  let component: AddUsCountyDataComponent;
  let fixture: ComponentFixture<AddUsCountyDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUsCountyDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUsCountyDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
