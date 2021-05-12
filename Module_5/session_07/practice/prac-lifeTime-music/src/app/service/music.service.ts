import { Injectable } from '@angular/core';
import {Song} from '../model/Song';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  public listSong:Song[] = [
    {
      id: '-MioPF-Gxsk',
      name: 'Góc Tâm Trạng 01 ~ 3107 2... Thì Thôi Anh Sẽ Ở Lại'
    },
    {
      id: 'HZ3XumHDDwA',
      name: '3107-2 - Sau Này Liệu Chúng Ta - Sợ Lắm 2 ft. Hẹn Yêu'
    },
    {
      id: 'nup3mH5aUrA',
      name: 'Bao Tiền Một Mớ Bình Yên? (Freak D Lofi Ver.) - 14 Casper & Bon'
    },
    {
      id: 'uelHwf8o7_U',
      name: 'Eminem - Love The Way You Lie ft. Rihanna'
    },
    {
      id: 'lfB5k5vokKU',
      name: 'Chẳng Thể Tìm Được Em, Thế Thái, Nơi Em Thuộc Về Anh... | Nhạc Lofi'
    }
  ]

  constructor() { }

  findSongById(id: string) {
    return this.listSong.find(item => item.id === id);
  }
}
