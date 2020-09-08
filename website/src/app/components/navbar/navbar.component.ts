import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input()
  loggedIn: boolean;

  @Output() loggingIn = new EventEmitter<void>()

  constructor() {
    this.loggedIn = true;
  }

  ngOnInit(): void {
  }

  login(e): void {
    e.preventDefault();
    this.loggingIn.emit();
  }
}
