import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';

@Component({
  selector: 'app-new-user-form',
  templateUrl: './new-user-form.component.html',
  styleUrls: ['./new-user-form.component.css']
})
export class NewUserFormComponent implements OnInit {

  newUser: User;

  constructor() {

  }

  ngOnInit(): void {
  }

  formSubmit($event: any) {
    
  }
}
