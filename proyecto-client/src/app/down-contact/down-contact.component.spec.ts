import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DownContactComponent } from './down-contact.component';

describe('DownContactComponent', () => {
  let component: DownContactComponent;
  let fixture: ComponentFixture<DownContactComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DownContactComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DownContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
