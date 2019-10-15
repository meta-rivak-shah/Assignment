import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Task } from '../task-model/task-model';
import { TaskModelService } from '../task-model/task-model.service';
import { Router, ActivatedRoute  } from '@angular/router';
@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {
  taskEditForm: FormGroup;
  submitted = false;
  taskModel:Task;
  toEditTask:Task;
  completeDate:any =null;
  constructor(private fb: FormBuilder, private taskService: TaskModelService,
    private router: Router, private activatedRoute :ActivatedRoute ) {

  }
 

  ngOnInit() {

    var date = this.activatedRoute.snapshot.paramMap.get("date");

     var task = this.taskService.taskList;
      for(var i = 0 ; i < task.length; i++) {
        if(String(task[i].creationDate) == date) {
          this.toEditTask = task[i];
        }
      }
    this.taskEditForm = this.fb.group({
      taskName: ['', Validators.required],
      taskDescription: ['', Validators.required],
      priority: [''],
      status: ['']
    });
  }

  get fval() {
    return this.taskEditForm.controls;
  }

  save() {
    this.taskService.updateTask(this.taskModel);
  }
  signup() {
    this.submitted = true;
    if (this.taskEditForm.invalid) {
      return;
    }

    if(this.taskEditForm.value.status=="Completed"){
      this.completeDate = Date.now();
    }
    // console.log("name:", this.toEditTask.creationDate);
    
    this.taskModel=new Task(this.taskEditForm.value.taskName, 
      this.taskEditForm.value.taskDescription,
      this.taskEditForm.value.priority,
      this.taskEditForm.value.status, 
      this.toEditTask.creationDate, 
      this.completeDate);
      console.log(new Date(this.completeDate));

      this.save();  
      this.router.navigate(['/my-task-tracker'])  

  }

  deleteTask(){
    this.taskService.deleteTask(this.toEditTask);
    this.router.navigate(['/my-task-tracker']) 
  }

}
