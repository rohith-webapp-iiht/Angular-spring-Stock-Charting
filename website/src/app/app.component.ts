import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'website';

  loggedIn = false;

  showLoginForm = false;

  showCreateUserForm = true;

  showLoginFormEvent():void {
    this.showLoginForm = true;
    this.showCreateUserForm = false;
  }

  showCreateUserFormEvent() {
    this.showLoginForm = false;
    this.loggedIn = false;
    this.showCreateUserForm = true;
  }
}
