import { Injectable } from '@angular/core';

import { Provider } from './Provider';
import { PROVIDERS } from './provider-data';

@Injectable()
export class ProviderService {
  getProviders(): Promise<Provider[]> {
      return Promise.resolve(PROVIDERS);
  }
}
