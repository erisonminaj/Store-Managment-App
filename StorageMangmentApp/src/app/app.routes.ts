import { Routes } from '@angular/router';
import {ProductComponent} from "./product/productComponent";

import {UserComponent} from "./user/user.component";

export const routes: Routes = [
  { path: 'products', component: ProductComponent},
  { path: 'users', component: UserComponent }
];
