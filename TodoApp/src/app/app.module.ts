import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { TaskModelComponent } from './task-model/task-model.component';
import { AllTodoComponent } from './all-todo/all-todo.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { TaskDetailsComponent } from './task-details/task-details.component';
const appRoutes: Routes = [
  { path: 'new-task', component: NewTaskComponent },
  { path: 'app-component', component: AppComponent },
  { path: 'my-task-tracker', component: AllTodoComponent},
  {path: 'edit-task/:date', component: EditTaskComponent },
  {path: 'task-details/:date', component: TaskDetailsComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NewTaskComponent,
    TaskModelComponent,
    AllTodoComponent,
    EditTaskComponent,
    TaskDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
