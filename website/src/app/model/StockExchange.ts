import {Address} from './Address';

export interface StockExchange{
  id: number;

  name: string;

  brief: string;

  address: Address;

  remarks: string;
}
