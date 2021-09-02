import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUsCountiesComponent } from './add-us-counties.component';

describe('AddUsCountiesComponent', () => {
  let component: AddUsCountiesComponent;
  let fixture: ComponentFixture<AddUsCountiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUsCountiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUsCountiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
