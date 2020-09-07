import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockCodesComponent } from './stock-codes.component';

describe('StockCodesComponent', () => {
  let component: StockCodesComponent;
  let fixture: ComponentFixture<StockCodesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockCodesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockCodesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
