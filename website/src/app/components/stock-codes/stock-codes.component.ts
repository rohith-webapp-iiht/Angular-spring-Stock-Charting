import {Component, Input, OnInit} from '@angular/core';
import {StockCode} from '../../model/StockCode';

@Component({
  selector: 'app-stock-codes',
  templateUrl: './stock-codes.component.html',
  styleUrls: ['./stock-codes.component.css']
})
export class StockCodesComponent implements OnInit {

  @Input()
  stockCode: StockCode;

  @Input()
  viewCompany?: boolean;

  @Input()
  viewStockExchange?: boolean;

  constructor() { }

  ngOnInit(): void {
  }

  codeClick(e: MouseEvent) {
    e.preventDefault();
  }

  stockExchangeClick(e: MouseEvent) {
    e.preventDefault();
    this.viewStockExchange = !this.viewStockExchange;
  }
}
