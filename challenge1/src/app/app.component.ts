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

    <select id = "category" (change)="selectCat()">
         <option value="null">-- Select --</option>
         <option value="last_name">Last Name</option>
         <option value="first_name">First Name</option>
         <option value="email_address">Email</option>
         <option value="specialty">Specialty</option>
         <option value="practice_name">Practice Name</option>
    </select>
    <select id = "direct" (change)="selectDirection()">
         <option value="forward">Forward</option>
         <option value="backward">Backward</option>
    </select>
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
  category: string = null;
  direction: number = 1;
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

  removeProvider(): void {
      if (this.selectedProvider !== null){
          var i : number = this.providers.indexOf(this.selectedProvider);
          this.providers.splice(i,1);
          this.selectedProvider = null;
      }
  }

  selectCat(): void {
      this.category = document.getElementById('category').value;
      this.sortProviders()
  }

  selectDirection(dirct:string): void {
      var temp : string = document.getElementById('direct').value;
      this.direction = ( temp === 'forward') ? 1 : -1;
      this.sortProviders()
  }


  sortProviders(): void{
      var that = this;
      if (this.category === 'last_name'){
          this.providers=this.providers.sort(function(a: Provider,b: Provider): number{
              if (a.last_name < b.last_name) return -1*that.direction;
              else if (a.last_name > b.last_name) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === 'first_name'){
          this.providers=this.providers.sort(function(a: Provider,b: Provider): number{
              if (a.first_name < b.first_name) return -1*that.direction;
              else if (a.first_name > b.first_name) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === 'email_address'){
          this.providers=this.providers.sort(function(a: Provider,b: Provider): number{
              if (a.email_address < b.email_address) return -1*that.direction;
              else if (a.email_address > b.email_address) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === 'specialty'){
          this.providers=this.providers.sort(function(a: Provider,b: Provider): number{
              if (a.specialty < b.specialty) return -1*that.direction;
              else if (a.specialty > b.specialty) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === "practice_name"){
          this.providers=this.providers.sort(function(a: Provider,b: Provider): number{
              if (a.practice_name < b.practice_name) return -1*that.direction;
              else if (a.practice_name > b.practice_name) return 1*that.direction;
              else return 0;
          })
      }
  }

}
