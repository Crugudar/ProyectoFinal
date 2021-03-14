import { Component, OnInit } from '@angular/core';
import { identity, iif } from 'rxjs';
import { Message } from '../models/message';
import { ProyectoService } from '../services/proyecto.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  messagesNotRead: Message[] = [];

  messagesRead: Message[] = [];

  readMessage: number;

  isDisplayNew:boolean=false;

  isDisplayRead:boolean=false;

  constructor(
    private proyectoService:ProyectoService
  ) { }

  ngOnInit(): void {
    this.proyectoService.messages().subscribe(dataResult => {
      dataResult.forEach(result => {
        let message:Message= new Message(
          result.messageId,
          result.clientName,
          result.clientEmail,
          result.phone,
          result.read,
          result.messageBody
        );
        
        console.log(result)
        if(message.isRead===true){
          this.messagesRead.push(message);
        }else{
          this.messagesNotRead.push(message);
        }
        
      })
    });
  }

  markAsRead(index:number, id:number){
    this.proyectoService.markAsRead(id).subscribe(data=>{
      let change=this.messagesNotRead.splice(index,1);
      this.messagesRead.push(change[0]);
    });
    
  }

  deleteMessage(index:number, id:number){
    this.proyectoService.delete(id).subscribe(data=>{
      let change=this.messagesRead.splice(index,1);
    });
  }
  
  displayNew(){
    if(this.isDisplayRead===true){
      this.isDisplayRead=false;
    }
    this.isDisplayNew=true;
  }

  displayRead(){
    if(this.isDisplayNew===true){
      this.isDisplayNew=false;
    }
    this.isDisplayRead=true;
  }

}
