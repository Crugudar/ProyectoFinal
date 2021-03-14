import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Message } from '../models/message';
import { ProyectoService } from '../services/proyecto.service';


@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  form: FormGroup;

  nameField: FormControl;
  emailField: FormControl;
  phoneField:FormControl;
  commentField: FormControl;
  // especialidadField: FormControl;

  //proyectoService: ProyectoService

  constructor(private proyectoService: ProyectoService) {
    // Initialize Form Control fields
    this.nameField = new FormControl('', [ Validators.required]);
    this.emailField = new FormControl('', [ Validators.required, Validators.email]);
    this.phoneField =new FormControl('', [ Validators.required, Validators.pattern('[(6|9)[0-9]{9}]*')]);
    this.commentField = new FormControl('', [ Validators.required, Validators.minLength(10) ]);
    // this.especialidadField = new FormControl('', [ Validators.required]);

    // Initialzie Form Group
    this.form = new FormGroup({
      name: this.nameField,
      email: this.emailField,
      phone: this.phoneField,
      comment: this.commentField,
      // especialidad: this.especialidadField
    });

    
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.form);
  }

  addMessage(){
    let addedMessage = { clientName:this.nameField.value, clientEmail:this.emailField.value, phone:this.phoneField.value, messageBody:this.commentField.value};
    
    this.proyectoService.addMessage(addedMessage).subscribe((data)=>{
      console.log(data);
    });

    this.form.reset();


  
  }

}
