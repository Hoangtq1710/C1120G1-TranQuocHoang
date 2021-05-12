import { Component, OnInit } from '@angular/core';
import {Song} from '../../model/Song';
import {MusicService} from '../../service/music.service';

@Component({
  selector: 'app-music-list',
  templateUrl: './music-list.component.html',
  styleUrls: ['./music-list.component.css']
})
export class MusicListComponent implements OnInit {

  public playlist: Song[] = [];

  constructor(private musicService:MusicService) { }

  ngOnInit(): void {
    this.playlist = this.musicService.listSong;
  }

}
