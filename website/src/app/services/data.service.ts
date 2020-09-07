import { Injectable } from '@angular/core';
import {Company} from '../model/Company';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  searchResults: Company[];

  constructor() {
    this.searchResults = [
      {
        id: 10,
        name: 'SocGen',
        turnover: 100000
      },
      {
        id: 10,
        name: 'SocGen',
        turnover: 100000
      }
    ];
  }

  getSearchResults(searchText: string): Observable<Company[]> {
    return of(this.searchResults);
  }
}
