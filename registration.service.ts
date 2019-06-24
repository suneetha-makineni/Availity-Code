/**
 * Created by sm94826 on 6/23/2019.
 */
import { Injectable }   from '@angular/core';
import { Response, Headers, Http, RequestOptions }   from '@angular/http';
import 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RegistrationService {

  constructor( private _http:Http) {
  }

  submitRegistration(registrationRequest):Observable<Response> {

    return this._http.post('/private/v1/registration', registrationRequest);
  }

}

