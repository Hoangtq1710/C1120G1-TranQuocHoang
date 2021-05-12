import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DictionaryComponent } from './dictionary/dictionary.component';
import { DictionaryListComponent } from './dictionary/dictionary-list/dictionary-list.component';
import { DetailsComponent } from './dictionary/details/details.component';

@NgModule({
  declarations: [
    AppComponent,
    DictionaryComponent,
    DictionaryListComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
