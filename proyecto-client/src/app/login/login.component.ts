import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomValidators } from 'src/app/utils/custom-validators';
import { ProyectoService } from '../services/proyecto.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  nameField: FormControl;
  emailField: FormControl;
  passwordField: FormControl;
 

  constructor(private proyectoService:ProyectoService) {
    // Initialize Form Control fields
    this.nameField = new FormControl('', [ Validators.required]);
    this.emailField = new FormControl('', [ Validators.required, Validators.email ]);
    this.passwordField = new FormControl('', [ Validators.required, Validators.minLength(7) ]);
    

    // Initialzie Form Group
    this.form = new FormGroup({
      name: this.nameField,
      email: this.emailField,
      password: this.passwordField,
      
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.form);
    let user={username:this.nameField.value, password:this.passwordField.value}
    this.proyectoService.authenticate(user).subscribe( data => {
      console.log(data);
    });
  }

}
