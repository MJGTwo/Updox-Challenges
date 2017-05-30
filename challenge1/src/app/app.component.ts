import { Component, OnInit } from '@angular/core';
import {Provider } from './provider';
import { ProviderService } from './provider.service';


@Component({
  selector: 'my-app',
  template: `
    <h1>{{title}}</h1>
    <h4>v2.0</h4>
    <button (click)="addProvider('LastName','FirstName','Email@example.com','Specialty','ProviderName')">Add</button>
    <button (click)="removeProvider()">Remove</button>
    <ul class="providers">
      <li *ngFor="let provider of providers"
      [class.selected]="provider === selectedProvider"
        (click)="(provider === selectedProvider) ? onSelect(null):onSelect(provider)">
        <span class="badge">{{provider.last_name}}, {{provider.first_name}}</span> {{provider.email_address}}
        <br> <span>{{provider.specialty}}</span>
        <br> <span>{{provider.practice_name}}</span>
      </li>
    </ul>
    <provider-detail [provider]="selectedProvider"></provider-detail>
    <div [class.selected]="newProvider">

    </div>
    `,
    styles: [`

`],
  providers: [ProviderService]
})
export class AppComponent implements OnInit {
  title = 'Provider Dictionary';
  providers : Provider[];
  selectedProvider: Provider = null;

  onSelect(provider: Provider): void {
    this.selectedProvider = provider;
  }

  constructor(private providerService: ProviderService) { }

  getProviders(): void {
   this.providerService.getProviders().then(providers => this.providers = providers);
 }

  ngOnInit(): void {
    this.getProviders();
  }

  addProvider(l_name: string, f_name: string, e_addr: string, special: string, prac_name: string): void {
      var temp : Provider = {
          last_name : l_name,
          first_name : f_name,
          email_address : e_addr,
          specialty : special,
          practice_name : prac_name
      };

      this.providers.push(temp);
      this.selectedProvider = this.providers[this.providers.length-1];
  }

  removeProvider(){
      if (this.selectedProvider !== null){
          var i : number = this.providers.indexOf(this.selectedProvider);
          this.providers.splice(i,1);
          this.selectedProvider = null;
      }
  }

}
