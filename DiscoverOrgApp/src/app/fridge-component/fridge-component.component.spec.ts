import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FridgeComponentComponent } from './fridge-component.component';

describe('FridgeComponentComponent', () => {
  let component: FridgeComponentComponent;
  let fixture: ComponentFixture<FridgeComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FridgeComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FridgeComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
