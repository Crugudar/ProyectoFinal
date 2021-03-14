import { Component, OnInit } from '@angular/core';
import { faInstagram, faFacebook } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-up-contact-bar',
  templateUrl: './up-contact-bar.component.html',
  styleUrls: ['./up-contact-bar.component.css']
})
export class UpContactBarComponent implements OnInit {

  faInstagram = faInstagram;
  faFacebook=faFacebook;

  constructor() { }

  ngOnInit(): void {
  }

}
