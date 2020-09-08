import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../model/user';
import {NewUserSubmissionService} from '../../services/new-user-submission.service';

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

  constructor(
    private service: NewUserSubmissionService
  ) {
    this.newUser = {
      accessType: '',
      email: '',
      firstName: '',
      lastName: '',
      username: '',
      confirmed: false,
      password: ''
    };
  }

  ngOnInit(): void {
  }

  private checkUser(user: User): boolean{
    //Add verification for the user
    return true
  }

  formSubmit($event: any) {
    if(this.checkUser(this.newUser)){
      this.service.addUser(this.newUser).subscribe(
        res =>{
          this.produceResponse(res);
        }
      )
    }else{
      alert("There is an error with the user details entered")
    }

  }
ap
  private produceResponse(res: any) {
    console.log(res);
  }
}
