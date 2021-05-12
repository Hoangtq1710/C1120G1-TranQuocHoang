import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LifeTimeComponent } from './life-time/life-time.component';
import {ReactiveFormsModule} from '@angular/forms';
import { MusicComponent } from './music/music.component';
import { MusicListComponent } from './music/music-list/music-list.component';
import { PlayerComponent } from './music/player/player.component';

@NgModule({
  declarations: [
    AppComponent,
    LifeTimeComponent,
    MusicComponent,
    MusicListComponent,
    PlayerComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
