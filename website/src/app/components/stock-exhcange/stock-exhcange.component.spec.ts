import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockExhcangeComponent } from './stock-exhcange.component';

describe('StockExhcangeComponent', () => {
  let component: StockExhcangeComponent;
  let fixture: ComponentFixture<StockExhcangeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockExhcangeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockExhcangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
