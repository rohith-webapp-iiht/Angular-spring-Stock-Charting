import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  username: string;

  password: string;

  constructor() { }

  ngOnInit(): void {
  }

  formSubmit(loginForm: any) {
    if(loginForm.valid){
      
    }

  }
}
