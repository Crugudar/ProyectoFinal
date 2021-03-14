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

  selectedMessage:Message |null;

  selectedIndex:number|null;

  isDisplayNew:boolean=false;

  isDisplayRead:boolean=false;

  constructor(
    private proyectoService:ProyectoService
  ) { }

  ngOnInit(): void {
    this.makeLists();
  }

  makeLists(){
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
        
        if(message.isRead===true){
          this.messagesRead.push(message);
        }else{
          this.messagesNotRead.push(message);
        }
        
      })
    });
  }

  messageDetails(id:number,index:number ,list:number){
    this.selectedIndex=index;

    if(list===1){
      let selected=this.messagesNotRead.filter(obj => {
        return obj.id === id;
      })
      this.selectedMessage=selected[0];
    }else{
      let selected=this.messagesRead.filter(obj => {
        return obj.id === id;
      })
      this.selectedMessage=selected[0];
    }
  }

  markAsRead(id:number){
    this.proyectoService.markAsRead(id).subscribe(data=>{
      if(this.selectedIndex!=null){
        let change=this.messagesNotRead.splice(this.selectedIndex,1);
        this.messagesRead.push(change[0]);
        console.log('index',this.selectedIndex);
        console.log('not read',this.messagesNotRead);
        console.log('read',this.messagesRead)
      }

      this.selectedMessage=null;
      this.selectedIndex=null;
      
    });

    
    
  }

  deleteMessage( id:number){
    this.proyectoService.delete(id).subscribe(data=>{
      if(this.selectedIndex!=null){
        let change=this.messagesRead.splice(this.selectedIndex,1);
        console.log(this.messagesRead)
      }
      this.selectedMessage=null;
      this.selectedIndex=null;
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
