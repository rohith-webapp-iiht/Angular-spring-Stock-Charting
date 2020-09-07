import {Component, OnInit} from '@angular/core';
import {Company} from '../../model/Company';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  company: Company;

  constructor() {
  }

  ngOnInit(): void {
    //Dummy Data
    this.company =
      {
        address: {
          addressLine1: 'Company address line 1',
          addressLine2: 'Company address line 2',
          addressLine3: 'Company address line 3',
          city: 'vijayawada',
          pincode: 521137
        },
        bod: [{
          id: 30,
          name: 'Board Member1 Name',
          bio: 'Board Member1 bio'
        },
          {
            id: 30,
            name: 'Board Member2 Name',
            bio: 'Board Member2 bio'
          },
          {
            id: 40,
            name: 'Board Member3 Name',
            bio: 'Board Member3 bio'
          }],
        ceo: {
          id: 20,
          name: 'Ceo Name',
          bio: 'Ceo bio'
        },
        furtherDetails: {
          description: 'Company description',
          services: 'Company, services',
          products: 'Savings account'
        },
        id: 10,
        name: 'SocGen',
        sector: {
          id: 10,
          name: 'Banking',
          brief: 'services'
        },
        stockCodes: [
          {
            id: 80,
            code: 'ABC',
            stockExchange: {
              id: 200,
              name: 'NSE',
              brief: 'National Stock Exchange',
              address: {
                addressLine1: 'stock exchange 1 address line 1',
                addressLine2: 'stock exchange 1 address line 2',
                addressLine3: 'stock exchange 1 address line 3',
                city: 'Delhi',
                pincode: 100001
              },
              remarks: 'Stock Exchange 1 remarks'
            },
            company: this.company,
          },
          {
            id: 80,
            code: 'ABD',
            stockExchange: {
              id: 100,
              name: 'Bse',
              brief: 'Bombay Stock Exchange',
              address: {
                addressLine1: 'stock exchange 2 address line 1',
                addressLine2: 'stock exchange 2 address line 2',
                addressLine3: 'stock exchange 2 address line 3',
                city: 'Bombay',
                pincode: 200001
              },
              remarks: 'Stock Exchange 2 remarks'
            },
            company: this.company
          }],
        turnover: 1000000,
        ipos: [
          {
            id: 10001,
            code: 'ABD',
            company: this.company,
            numberOfShares: 100000,
            openDate: new Date()
          }
        ],

      };
    this.company.ipos[0].stockCode = this.company.stockCodes[1];
    this.company.ipos[0].stockExchange = this.company.stockCodes[1].stockExchange;
    this.company.stockCodes[1].ipo = this.company.ipos[0];
  }

}
