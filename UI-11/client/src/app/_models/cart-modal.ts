
export class Cart{
    userId:Int16Array;
    productId:Int16Array;
    quantityId:Int16Array;

    constructor(userId, productId, quantityId){
        this.userId = userId;
        this.productId = productId;
        this.quantityId = quantityId;
    }
}