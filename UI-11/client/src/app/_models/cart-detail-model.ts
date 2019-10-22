
export class CartDetails{
    id:any;
    name:String;
    price:DoubleRange;
    quantity:Int16Array;
    imagePath:String;

    constructor(id, name, price, quantity, imagePath){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }
}