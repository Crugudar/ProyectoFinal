import { Component, OnInit } from '@angular/core';
import { faInstagram, faFacebook, faLinkedin } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  faInstagram = faInstagram;
  faFacebook=faFacebook;
  faLinkedin=faLinkedin;

  constructor() { }

  ngOnInit(): void {
  }

}
