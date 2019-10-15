import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskModelComponent } from './task-model.component';

describe('TaskModelComponent', () => {
  let component: TaskModelComponent;
  let fixture: ComponentFixture<TaskModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskModelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
