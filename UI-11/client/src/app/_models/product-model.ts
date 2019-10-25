
export interface Product{
    id:Int16Array;
    name:String;
    price:DoubleRange;
    description:String;
    imagePath:String;
    categoryName:String;

    // constructor(id, name, price, description, imagePath, categoryName){
    //     this.id = id;
    //     this.name = name;
    //     this.price = price;
    //     this.description = description;
    //     this.imagePath = imagePath;
    //     this.categoryName = categoryName;
    // }
}

export interface Products{
    products: Array<Product>
 }