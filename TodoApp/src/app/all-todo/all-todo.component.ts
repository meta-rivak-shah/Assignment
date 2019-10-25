import { Component, OnInit } from '@angular/core';
import{TaskModelService} from '../task-model/task-model.service'
import { Task } from '../task-model/task-model';
@Component({
  selector: 'app-all-todo',
  templateUrl: './all-todo.component.html',
  styleUrls: ['./all-todo.component.css']
})
export class AllTodoComponent implements OnInit {
  taskList:any;
  constructor(private taskService: TaskModelService) { }

  ngOnInit() {
    this.taskList = this.taskService.getAllTasks();
  }

}
