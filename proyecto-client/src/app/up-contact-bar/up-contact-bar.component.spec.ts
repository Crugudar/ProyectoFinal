import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpContactBarComponent } from './up-contact-bar.component';

describe('UpContactBarComponent', () => {
  let component: UpContactBarComponent;
  let fixture: ComponentFixture<UpContactBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpContactBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpContactBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
