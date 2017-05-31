import { Component, OnInit } from '@angular/core';
import {Provider } from './provider';
//import { ProviderService } from './provider.service';


const PROVIDERS: Provider[] = [
    {"last_name": "Harris", "first_name": "Mike", "email_address": "mharris@updox.com", "specialty": "Pediatrics", "practice_name": "Harris Pediatrics"},
    {"last_name": "Wijoyo", "first_name": "Bimo", "email_address": "bwijoyo@updox.com", "specialty": "Podiatry", "practice_name": "Wijoyo Podiatry"},
    {"last_name": "Rose", "first_name": "Nate", "email_address": "nrose@updox.com", "specialty": "Surgery", "practice_name": "Rose Cutters"},
    {"last_name": "Carlson", "first_name": "Mike", "email_address": "mcarlson@updox.com", "specialty": "Orthopedics", "practice_name": "Carlson Orthopedics"},
    {"last_name": "Witting", "first_name": "Mike", "email_address": "mwitting@updox.com", "specialty": "Pediatrics", "practice_name": "Witting's Well Kids Pediatrics"},
    {"last_name": "Juday", "first_name": "Tobin", "email_address": "tjuday@updox.com", "specialty": "General Medicine", "practice_name": "Juday Family Practice"}
];


@Component({
  selector: 'my-app',
  template: `
    <h1>{{title}}</h1>
    <h4>v2.0</h4>
    <input id="search" type="text" name="search" placeholder="Search.." (keyup) = "filter()"><br>
    <button (click)="addProvider('LastName','FirstName','Email@example.com','Specialty','ProviderName')">Add</button>
    <button (click)="removeProvider()">Remove</button>
    <select id="category" (change)="selectCat()">
         <option value="null">-- Select --</option>
         <option value="last_name">Last Name</option>
         <option value="first_name">First Name</option>
         <option value="email_address">Email</option>
         <option value="specialty">Specialty</option>
         <option value="practice_name">Practice Name</option>
    </select>
    <select id="direction" (change)="selectDirection()">
         <option value="forward">Forward</option>
         <option value="backward">Backward</option>
    </select>
    <ul class="providers">
      <li *ngFor="let provider of viewedProviders"
      [class.selected]="provider === selectedProvider"
        (click)="(provider === selectedProvider) ? onSelect(null):onSelect(provider)">
        <span class="badge">{{provider.last_name}}, {{provider.first_name}}</span> {{provider.email_address}}
        <br> <span>{{provider.specialty}}</span>
        <br> <span>{{provider.practice_name}}</span>
      </li>
    </ul>
    <provider-detail [provider]="selectedProvider"></provider-detail>

    `
})
export class AppComponent implements OnInit {

  title = 'Provider Dictionary';
  providers : Provider[];
  viewedProviders : Provider[] = this.providers;
  selectedProvider: Provider = null;
  category: string = null;
  direction: number = 1;
  onSelect(provider: Provider): void {
    this.selectedProvider = provider;
  }




  ngOnInit(): void {
    this.providers = PROVIDERS;
    this.viewedProviders = this.providers;
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
      this.filter()
  }

  removeProvider(): void {
      if (this.selectedProvider !== null){
          var i : number = this.providers.indexOf(this.selectedProvider);
          this.providers.splice(i,1);
          this.selectedProvider = null;
          this.filter()
      }
  }

  filter() : void {
      var search : HTMLInputElement = <HTMLInputElement> document.getElementById('search');
      var word : string = search.value.toLowerCase();
      var flag : boolean;
      this.viewedProviders = Array<Provider>();
      for (var i =0; i < this.providers.length; i++ ){
          flag = (this.providers[i].email_address.toLowerCase().includes(word) ||
                   this.providers[i].last_name.toLowerCase().includes(word) ||
                   this.providers[i].first_name.toLowerCase().includes(word) ||
                   this.providers[i].specialty.toLowerCase().includes(word) ||
                   this.providers[i].practice_name.toLowerCase().includes(word)
               );
           if (flag){
               this.viewedProviders.push(this.providers[i]);

           }


      }
  }

  selectCat(): void {
      var cat : HTMLSelectElement = <HTMLSelectElement> document.getElementById('category');

      this.category = cat.value;
      this.sortProviders()
  }

  selectDirection(dirct:string): void {
      var temp : HTMLSelectElement = <HTMLSelectElement> document.getElementById('direction');
      this.direction = ( temp.value === 'forward') ? 1 : -1;
      this.sortProviders()
  }


  sortProviders(): void{
      var that = this;
      this.filter();
      if (this.category === 'last_name'){
          this.viewedProviders=this.viewedProviders.sort(function(a: Provider,b: Provider): number{
              if (a.last_name < b.last_name) return -1*that.direction;
              else if (a.last_name > b.last_name) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === 'first_name'){
          this.viewedProviders=this.viewedProviders.sort(function(a: Provider,b: Provider): number{
              if (a.first_name < b.first_name) return -1*that.direction;
              else if (a.first_name > b.first_name) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === 'email_address'){
          this.viewedProviders=this.viewedProviders.sort(function(a: Provider,b: Provider): number{
              if (a.email_address < b.email_address) return -1*that.direction;
              else if (a.email_address > b.email_address) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === 'specialty'){
          this.viewedProviders=this.viewedProviders.sort(function(a: Provider,b: Provider): number{
              if (a.specialty < b.specialty) return -1*that.direction;
              else if (a.specialty > b.specialty) return 1*that.direction;
              else return 0;
          })
      }
      else if (this.category === "practice_name"){
          this.viewedProviders=this.viewedProviders.sort(function(a: Provider,b: Provider): number{
              if (a.practice_name < b.practice_name) return -1*that.direction;
              else if (a.practice_name > b.practice_name) return 1*that.direction;
              else return 0;
          })
      }

  }

}
