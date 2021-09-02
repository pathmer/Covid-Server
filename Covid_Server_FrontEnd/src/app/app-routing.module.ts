import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { SandboxpageComponent } from './components/sandboxpage/sandboxpage.component';

const routes: Routes = [
  // { path: 'workorder', component: WorkOrderFormComponent },
  { path: '', component: SandboxpageComponent }
  
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
