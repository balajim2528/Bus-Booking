import { Routes } from '@angular/router';
import { Welcome } from '../pages/welcome/welcome';
import { Passenger } from './passenger/passenger';

export const routes: Routes = [

 {
    path: '',
    redirectTo: 'welcome',
    pathMatch: 'full'
  },
  {
    path: 'welcome',
    component: Welcome
  },
  {
    path: 'passenger',
    component: Passenger
  },
  {
    path: '**',
    redirectTo: 'welcome'
  }


];
