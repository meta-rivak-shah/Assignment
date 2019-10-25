export class Task {
    taskName: string;
    taskDescription: string;
    taskPriority: string;
    status: string;
    creationDate: Date;
    completionDate: Date;

    constructor(taskName, taskDescription, taskPriority, status, creationDate, completionDate){
        this.taskName = taskName;
        this.taskDescription = taskDescription;  
        this.taskPriority = taskPriority; 
        this.status = status; 
        this.creationDate = creationDate; 
        this.completionDate = completionDate;
    }    
}
