import {Injectable} from '@angular/core';
import {User} from '../model/user';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class NewUserSubmissionService {

  private newUserApiUrl = 'http://localhost:8080/api/users/new_user'

  constructor(
    private http: HttpClient
  ) { }

  addUser(newUser: User): Observable<any> {
    console.log(newUser);
    return this.http.post(this.newUserApiUrl, newUser, httpOptions);
  }
}
