import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Task } from '../task-model/task-Model';
import { TaskModelService } from '../task-model/task-model.service';
@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
  taskForm: FormGroup;
  submitted = false;
  taskModel:Task;

  constructor(private formbuilder: FormBuilder, private taskService: TaskModelService,
    private router: Router) {

  }
 

  ngOnInit() {
    this.taskForm = this.formbuilder.group({
      taskName: ['', Validators.required],
      taskDescription: ['', Validators.required],
      priority: ['', Validators.required]
    });
  }
  get fval() {
    return this.taskForm.controls;
  }

  save(taskModel) {
    this.taskService.createTask(taskModel);
  }

  gotoList() {
    this.router.navigate(['/tasks']);
  }

  signup() {
    this.submitted = true;
    var taskModel=new Task(this.taskForm.value.taskName, 
      this.taskForm.value.taskDescription,
      this.taskForm.value.priority,
      "New", Date.now(), null);
      // console.log("aaa");
      // console.log("time",this.taskModel.creationDate);
      this.save(taskModel);  
      this.router.navigate(['/my-task-tracker']) 

    // alert('form fields are validated successfully!');
  }

}
