import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUsCountiesComponent } from './view-us-counties.component';

describe('ViewUsCountiesComponent', () => {
  let component: ViewUsCountiesComponent;
  let fixture: ComponentFixture<ViewUsCountiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewUsCountiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewUsCountiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
