import {StockCode} from './StockCode';
import {Company} from './Company';
import {StockExchange} from './StockExchange';

export class Ipo{
  id: number;

  code: string;

  stockCode?: StockCode;

  company?: Company;

  stockExchange?: StockExchange;

  numberOfShares: number;

  openDate: Date;
}
