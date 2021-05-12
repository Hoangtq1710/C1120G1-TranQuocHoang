import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PlayerComponent} from './music/player/player.component';
import {MusicComponent} from './music/music.component';
import {MusicListComponent} from './music/music-list/music-list.component';


const routes: Routes = [
  {
    path: 'youtube',
    component: MusicComponent,
    children: [
      {
        path: 'list',
        component: MusicListComponent,
        children: [{
          path: 'list/:id',
          component: PlayerComponent
        }]
      }]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
