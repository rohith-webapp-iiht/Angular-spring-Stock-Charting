import {Company} from './Company';
import {StockExchange} from './StockExchange';
import {Ipo} from './Ipo';

export class StockCode{
  id: number;

  code: string;

  stockExchange: StockExchange;

  company?: Company;
}
