import { Component, OnInit } from '@angular/core';
import { faInstagram, faFacebook } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-down-contact',
  templateUrl: './down-contact.component.html',
  styleUrls: ['./down-contact.component.css']
})
export class DownContactComponent implements OnInit {
  faInstagram = faInstagram;
  faFacebook=faFacebook;

  constructor() { }

  ngOnInit(): void {
  }

}
