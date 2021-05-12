import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DictionaryListComponent} from './dictionary/dictionary-list/dictionary-list.component';
import {DetailsComponent} from './dictionary/details/details.component';


const routes: Routes = [
  {
    path: 'dictionary',
    component: DictionaryListComponent
  },
  {
    path: 'dictionary/detail/:id',
    component: DetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
