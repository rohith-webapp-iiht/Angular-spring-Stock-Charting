import {Component, Input, OnInit} from '@angular/core';
import {Ipo} from '../../model/Ipo';

@Component({
  selector: 'app-ipo',
  templateUrl: './ipo.component.html',
  styleUrls: ['./ipo.component.css']
})
export class IpoComponent implements OnInit {

  @Input()
  ipo: Ipo

  showStockExchange: boolean;

  @Input()
  viewingCompany: boolean;

  showCompany: boolean;

  constructor() {
    this.showStockExchange = false;
  }

  ngOnInit(): void {
  }

  showStockExchangeClick($event: MouseEvent) {
    this.showStockExchange = !this.showStockExchange;
  }

  showCompanyClick($event: MouseEvent) {
    this.showCompany = !this.showCompany;

  }
}
