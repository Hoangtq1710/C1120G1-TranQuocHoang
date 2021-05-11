import {Component, OnInit} from '@angular/core';
import {Todo} from './TodoInterface';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  public listTodo: Todo[] = [];
  content = new FormControl();


  constructor() {
  }

  ngOnInit(): void {
  }

  toggleTodo(i: number) {
    this.listTodo[i].complete = !this.listTodo[i].complete;
  }

  change() {
    let _id = 1;
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.listTodo.push(todo);
      this.content.reset();
    }
  }
}
