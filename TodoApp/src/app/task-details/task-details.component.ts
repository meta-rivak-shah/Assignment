import { Component, OnInit } from '@angular/core';
import { Task } from '../task-model/task-model';
import { TaskModelService } from '../task-model/task-model.service';
import { Router, ActivatedRoute  } from '@angular/router';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  tempTask:Task;
  cd:Date;
  compD:Date;


  constructor(private taskService: TaskModelService,
    private router: Router, private activatedRoute :ActivatedRoute ) {

  }

  deleteTask(){
    this.taskService.deleteTask(this.tempTask);
    this.router.navigate(['/my-task-tracker']) 
  }

  ngOnInit() {
    this.taskService.taskList.forEach((t: Task) => {
      if (t.creationDate.toString() == (this.activatedRoute.snapshot.paramMap.get("date"))) {
        this.tempTask = t;
        console.log(String(this.tempTask.creationDate));
        this.cd = new Date(Number(this.tempTask.creationDate));
        if(this.tempTask.completionDate == null){
          
        }
        else{
          this.compD= new Date(Number(this.tempTask.completionDate));
        }
        
      }
    });

  }

}
