import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SandboxpageComponent } from './sandboxpage.component';

describe('SandboxpageComponent', () => {
  let component: SandboxpageComponent;
  let fixture: ComponentFixture<SandboxpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SandboxpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SandboxpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
