import { Component, OnInit } from '@angular/core';
import {Company} from '../../model/Company';
import {DataService} from '../../services/data.service';

@Component({
  selector: 'app-search-for-company',
  templateUrl: './search-for-company.component.html',
  styleUrls: ['./search-for-company.component.css']
})
export class SearchForCompanyComponent implements OnInit {

  searchText: string;

  smallText: boolean;

  showingResults: boolean;

  searchResults: Company[];

  loaded: boolean;

  searchedText: string;

  constructor(private dataService: DataService) {
    this.searchText = '';
    //Dummy
    // this.showingResults = true;
  }

  ngOnInit(): void {
  }


  search_submit(e: any): void {
    e.preventDefault();
    this.showingResults = true;
    //Filter or change the existing search results here
    this.findResults();
  }

  findResults() {
    var s: string = this.searchText;
    this.dataService.getSearchResults(this.searchText).subscribe(searchResults => {
      this.searchResults = searchResults;
      this.loaded = true;
      this.searchedText = s;
    });
  }

  check_text(): void {
    // this.showingResults = (this.searchText.length > 3);
    //For dynamic reuslts
  }
}
