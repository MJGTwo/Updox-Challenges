import { Component, Input } from '@angular/core';
import { Provider } from './provider';
@Component({
  selector: 'provider-detail',
  template: `
    <div *ngIf="provider">
      <h2>{{provider.last_name}}, {{provider.first_name}} details:</h2>
      <div>
        <label>First Name: </label>
        <input [(ngModel)]="provider.first_name" placeholder="first_name"/>
        <label>Last Name: </label>
        <input [(ngModel)]="provider.last_name" placeholder="last_name"/>
        <br>
        <label>Email Addr: </label>
        <input [(ngModel)]="provider.email_address" placeholder="email_address"/>
        <br>
        <label>Specialty: </label>
        <input [(ngModel)]="provider.specialty" placeholder="specialty"/>
        <label>Name of Practice: </label>
        <input [(ngModel)]="provider.practice_name" placeholder="practice_name"/>
      </div>
    </div>
  `
})
export class ProviderDetailComponent {
  @Input() provider: Provider;
}
