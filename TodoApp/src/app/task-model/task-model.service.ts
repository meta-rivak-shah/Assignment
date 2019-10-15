import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';


import { Task } from './task-model';

@Injectable({
    providedIn: 'root'
})
export class TaskModelService {

    taskList: Task[] = [];
    task1: Task;

    constructor() { }

    getAllTasks() {
        this.taskList = [];
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                console.log(key, localStorage.getItem(String(key)));
                this.taskList.push(this.stringToTask(localStorage.getItem(String(key))));
            }
        }
        localStorage.key
        return this.taskList;
    }

    stringToTask(str: string) {
        var tempStr = str.split(",");
        // console.log(tempStr[0], tempStr[4]);

        if (tempStr[5] == "null") {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], null);
        }
        else {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], tempStr[5]);
            // this.task1.completionDate = new Date(tempStr[5]);
        }
        // console.log(this.task1.taskName);
        return this.task1;
    }

    taskToString(task: Task) {
        var tTs = task.taskName + ','
            + task.taskDescription + ',' + task.taskPriority
            + ',' + task.status + ',' + task.creationDate
            + ',' + task.completionDate;

        return tTs;
    }

    //Create Task
    createTask(task: Task) {
        var taskIntoString = this.taskToString(task);
        localStorage.setItem(String(task.creationDate), taskIntoString);
        console.log(task.creationDate);
    }

    //Update task
    updateTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (key == String(task.creationDate)) {
                    console.log(task.status);
                    localStorage.setItem(String(key), this.taskToString(task));
                }
            }
        }
    }
    //Delete task	
    deleteTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (key == String(task.creationDate)) {
                    localStorage.removeItem(String(key));
                }
            }
        }
    }
    private handleError(error: any) {
        console.error(error);
        return throwError(error);
    }
}