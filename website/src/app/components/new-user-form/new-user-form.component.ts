import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../model/user';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-new-user-form',
  templateUrl: './new-user-form.component.html',
  styleUrls: ['./new-user-form.component.css']
})
export class NewUserFormComponent implements OnInit {

  @Input()
  newUser: User;
  AccessTypes = ['Normal User','Admin'];

  passwordRentry: string;

  constructor() {
    this.newUser = {
      accessType: '',
      email: '',
      firstName: '',
      lastName: '',
      username: '',
      confirmed: false

    };
  }

  ngOnInit(): void {
  }

  formSubmit($event: any) {

    console.log(this.newUser);

  }
}
