/**
 * Created by sm94826 on 6/23/2019.
 */
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from './service/registration.service';
import { Registration } from './model/Registration';

@Component({
  selector: 'app-reg',
  templateUrl: './registration.component.html',
})

export class RegistrationComponent implements OnInit {

  registrationForm: FormGroup;
  firstName : FormControl;
  lastName : FormControl;
  npiNumber : FormControl;
  address : FormControl;
  phoneNumber: FormControl;
  email:FormControl;

  constructor(private router: Router,
              private registrationService: RegistrationService) {
  }

  createFormControls() {
    this.firstName = new FormControl("", Validators.required);
    this.lastName = new FormControl("", Validators.required);
    this.npiNumber = new FormControl("", Validators.required);
    this.address = new FormControl("", Validators.required);
    this.phoneNumber = new FormControl("", Validators.required);
    this.email = new FormControl("", Validators.required);
  }

  createForm() {
    this.registrationForm = new FormGroup({
        firstName: this.firstName,
        lastName: this.lastName,
        npiNumber:this.npiNumber,
        address:this.address,
        phoneNumber:this.phoneNumber,
        email:this.email
    });
  }

  ngOnInit() {
    this.createFormControls();
    this.createForm();
  }

  submitRegistration() {
    if(this.registrationForm.valid) {
      let registrationRequest = new Registration({
        firstName: this.firstName,
        lastName: this.lastName,
        npiNumber: this.npiNumber,
        address: this.address,
        phoneNumber: this.phoneNumber,
        email: this.email
      });

      this.registrationService.submitRegistration(registrationRequest).subscribe(
          error => this.handleError(error)
      );
    }
  }

  handleError(errorData ){
    console.log('handleError : '+ JSON.stringify(errorData));
    this.router.navigate(['']);
  }

}

