import {Component, Input, OnInit} from '@angular/core';
import {StockExchange} from '../../model/StockExchange';

@Component({
  selector: 'app-stock-exhcange',
  templateUrl: './stock-exhcange.component.html',
  styleUrls: ['./stock-exhcange.component.css']
})
export class StockExhcangeComponent implements OnInit {

  @Input()
  stockExchange: StockExchange;

  constructor() { }

  ngOnInit(): void {
  }

}
