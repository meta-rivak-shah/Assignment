package get2019.assignment;
import java.util.*; 

public abstract class Ecommerce {
		public abstract void showProduct();
		public abstract int addProductToCart(String productName,String quntity);
		public abstract int updateProductToCart(int productId,int quntity);
		public abstract void genrateBillOfCart(
				HashMap<Integer, String> cartContainProductName2,
				HashMap<Integer, Integer> cartContainProductPrice2);
}
