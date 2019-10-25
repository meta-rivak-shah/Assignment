import { Component, OnInit, Output, EventEmitter} from '@angular/core';


@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

 Category :String="none";
  constructor() { }

  @Output() valueChange = new EventEmitter();

  ngOnInit() {
  }

  getCategoryValue(){
    console.log("l",this.Category);
    return this.Category;
    
  }
  categorySelection(category){
console.log("cat",category);
    switch(category) { 
      case 'all':
        this.Category = "none";
        this.valueChange.emit(this.Category);
        break;
    case 'bread':
      this.Category = "Bread";
      this.valueChange.emit(this.Category);
        break;
    case 'dairy':
      this.Category = "Dairy";
      this.valueChange.emit(this.Category);
        break;
    case 'fruits':
      this.Category = "Fruits";
      this.valueChange.emit(this.Category);
        break;
    case 'spices':
      this.Category = "Seasonings And Spices";
      this.valueChange.emit(this.Category);
        break;
    case 'vegetables':
      this.Category = "Vegetables";
      this.valueChange.emit(this.Category);
        break;
    default:
      this.Category = "none";
        break;
} 
  }

}
