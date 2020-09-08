import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input()
  loggedIn: boolean;

  @Input()
  showSignUpButton: boolean;

  @Input()
  showLoginButton: boolean;

  @Output() loggingIn = new EventEmitter<void>();

  @Output() signingUp = new EventEmitter<void>();

  constructor() {

  }

  ngOnInit(): void {
  }

  login(e): void {
    e.preventDefault();
    this.showLoginButton = !this.showLoginButton;
    this.showSignUpButton = ! this.showSignUpButton;
    this.loggingIn.emit();
  }

  signUp(e): void {
    e.preventDefault();
    this.showLoginButton = !this.showLoginButton;
    this.showSignUpButton = ! this.showSignUpButton;
    this.signingUp.emit();
  }
}
