import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `
    <h1>{{title}}</h1>
    <h4>v2.0</h4>
    <ul class="providers">
      <li *ngFor="let provider of providers">
        <span class="badge">{{provider.last_name}}, {{provider.first_name}}</span> {{provider.email_address}}
        <br> <span>{{provider.specialty}}</span>
        <br> <span>{{provider.practice_name}}</span>
      </li>
    </ul>

    `,
    styles: [`
  .selected {
    background-color: #CFD8DC !important;
    color: white;
  }
  .providers {
    margin: 0 0 2em 0;
    list-style-type: none;
    padding: 0;
    width: 25em;
  }
  .providers li {
    cursor: pointer;
    position: relative;
    left: 0;
    background-color: #EEE;
    margin: 0.5em;
    padding: .3em 0;
    height: 5.6em;
    border-radius: 4px;
  }
  .providers li.selected:hover {
    background-color: #BBD8DC !important;
    color: white;
  }
  .providers li:hover {
    color: #607D8B;
    background-color: #DDD;
    left: .1em;
  }
  .providers .text {
    position: relative;
    top: -3px;
  }
  .providers .badge {
    display: inline-block;
    font-size: small;
    color: white;
    padding: 0.8em 0.7em 0 0.7em;
    background-color: #607D8B;
    line-height: 1em;
    position: relative;
    left: -1px;
    top: -4px;
    height: 1.8em;
    margin-right: .8em;
    border-radius: 4px 0 0 4px;
  }
`]

})
export class AppComponent {
  title = 'Provider Dictionary';
  providers = PROVIDERS;
  selectedProvider: Provider;
  onSelect(provider: Provider): void {
    this.selectedProvider = provider;
  }

}

export class Provider {
  last_name: string;
  first_name: string;
  email_address: string;
  specialty: string;
  practice_name: string;

}

const PROVIDERS: Provider[] = [
    {"last_name": "Harris", "first_name": "Mike", "email_address": "mharris@updox.com", "specialty": "Pediatrics", "practice_name": "Harris Pediatrics"},
    {"last_name": "Wijoyo", "first_name": "Bimo", "email_address": "bwijoyo@updox.com", "specialty": "Podiatry", "practice_name": "Wijoyo Podiatry"},
    {"last_name": "Rose", "first_name": "Nate", "email_address": "nrose@updox.com", "specialty": "Surgery", "practice_name": "Rose Cutters"},
    {"last_name": "Carlson", "first_name": "Mike", "email_address": "mcarlson@updox.com", "specialty": "Orthopedics", "practice_name": "Carlson Orthopedics"},
    {"last_name": "Witting", "first_name": "Mike", "email_address": "mwitting@updox.com", "specialty": "Pediatrics", "practice_name": "Witting’s Well Kids Pediatrics"},
    {"last_name": "Juday", "first_name": "Tobin", "email_address": "tjuday@updox.com", "specialty": "General Medicine", "practice_name": "Juday Family Practice"}
];
