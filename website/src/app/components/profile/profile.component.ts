import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: User = {
    accessType: 'admin',
    email: 'prabhumns123@gmail.com',
    firstName: 'Prabhu',
    lastName: 'Madipalli',
    username: 'prabhumns'
  };
  showExtended: boolean;

  constructor() {
    this.showExtended = false;
  }

  ngOnInit(): void {
  }

}
