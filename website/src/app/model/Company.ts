import {Person} from './Person';
import {Sector} from './Sector';
import {StockCode} from './StockCode';
import {Ipo} from './Ipo';
import {Address} from './Address';

class CompanyDetails {
  description: string;
  services: string;
  products: string;
}

export class Company{
  id: number;
  name: string;
  turnover?: number;
  ceo?: Person;
  bod?: Person[];
  sector?: Sector;
  ipos? : Ipo[];
  stockCodes? : StockCode[];

  address? : Address;
  furtherDetails? : CompanyDetails;
}
