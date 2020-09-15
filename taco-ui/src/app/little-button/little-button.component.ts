import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-little-button',
  templateUrl: './little-button.component.html',
  styleUrls: ['./little-button.component.less']
})
export class LittleButtonComponent implements OnInit {

  @Input() label: String;

  constructor() { }

  ngOnInit(): void {
  }

}
