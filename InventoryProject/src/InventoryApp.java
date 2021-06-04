import java.util.Scanner;
public class InventoryApp {
	
	static Scanner sc = new Scanner(System.in);
	
	//menu
	static void displayMenu(){
		System.out.println("**********************************");
		System.out.println("1: Add Product");
		System.out.println("2: update the quantity of a product");
		System.out.println("3: find products below particular quantity ");
		System.out.println("4: sort products");
		System.out.println("5: Delete Products");
		System.out.println("6: Exit");
		System.out.println("**********************************");
	}
	
	// creating new product
	static Product createProduct() {
		
		System.out.println();
		System.out.println("Enter id of the product");
		long id = sc.nextLong();
		
		System.out.println("enter name of the product");
		String name = sc.next();
		
		System.out.println("enter quantity of the product");
		long quantity = sc.nextLong();
		
		System.out.println("enter the price of the product");
		long pricePerUnit = sc.nextLong();
	
		// calling of parameterized constructor
		Product product = new Product(id, name, quantity, pricePerUnit);
		
		return product;	
	}
	
	// Add product
	static Product[] addProduct(Product[] productContainer, Product product) {
		Product[] newProductContainer = new Product[productContainer.length + 1];
		
		for (int i = 0; i < productContainer.length; i++) {
			newProductContainer[i] = productContainer[i];  
			
		}
		newProductContainer[productContainer.length] = product;
		
		return newProductContainer;
 	}
	
	// Delete product
	static Product[] deleteProduct(Product[] productContainer, int index) {
		Product[] newProductContainer = new Product[productContainer.length-1];
		
		for (int i = 0; i < index; i++) {
			newProductContainer[i] = productContainer[i];		
		}
		
		for (int i = index + 1; i < productContainer.length; i++) {
			newProductContainer[i-1] = productContainer[i];
			
		}
		
		return newProductContainer;
	}
	
	// sorting product based on quantity
	static Product[] sortProduct(Product[] productContainer) {
		Product tempProduct;
		
		for(int i = 0; i < productContainer.length-1; i++) {
			for(int j = 0; j < productContainer.length - i- 1; j++) {
				if (productContainer[j].getQuantity() > productContainer[j+1].getQuantity()){
					tempProduct = productContainer[j];
					productContainer[j] = productContainer[j+1];
					productContainer[j+1] = tempProduct;
				}
			}
		}
		return productContainer;
	}
	
	static void displayProducts(Product[] productContainer) {
		for(int i = 0; i<productContainer.length; i++) {
			System.out.println("product ID" + productContainer[i].getId());
			System.out.println("Product name" + productContainer[i].getName());
			System.out.println("product quantity" + productContainer[i].getQuantity());
			System.out.println("product price" + productContainer[i].getPricePerUnit());
		    System.out.println();
		}
	}
	
	static void productBasedOnQuantity(Product[] productContainer, long quantity) {
		int count = 0;
		for(int i = 0; i < productContainer.length; i++) {
			if (productContainer[i].getQuantity() < quantity) {
				System.out.println("product ID: " + productContainer[i].getId());
				System.out.println("Product name: " + productContainer[i].getName());
				System.out.println("product quantity: " + productContainer[i].getQuantity());
				System.out.println("product price: " + productContainer[i].getPricePerUnit());
			    System.out.println();
			    count  = count + 1;
			}
			
		}
		
		if(count == 0)
			System.out.println("no product found less than the quantity you provided");
		    
	}
	
	//search product
	static int searchProduct(Product[] productContainer, int id) {
		for(int i = 0; i < productContainer.length; i++) {
			if (productContainer[i].getId() == id)
				return i;
		}
		return -1;
	}
	
	// update quantity
	static void updateProductQuantity(Product[] productContainer, int index, long quantity) {
					productContainer[index].setQuantity(quantity);	
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product ;
		Product[] productArray = new Product[0];
        int choice = 0;
        boolean flag = true;
        int id = 0;
        long quantity = 0;
		
        
        do {
			displayMenu();
			System.out.println("enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1: 
				System.out.println("enter the number of product you wish to add");
				int n = sc.nextInt();
				
				for(int i = 0; i < n; i++) {
					product = createProduct();
					productArray = addProduct(productArray,product);
				}
				break;
				
			case 2:
				System.out.println("enter the id of product you want to update quantity");
				id = sc.nextInt();
				
				System.out.println("enter the quantity");
				quantity = sc.nextLong();
				
				if ( searchProduct(productArray,id) == -1 ) {
					System.out.println("no product found");
				}else {
					updateProductQuantity(productArray,searchProduct(productArray,id),quantity);
				}
				break;
				
			case 3:
				System.out.println("enter quantity");
			    quantity = sc.nextLong();
				productBasedOnQuantity(productArray,quantity);
				break;
				
			case 4:
				sortProduct(productArray);
				displayProducts(productArray);
				break;
				
			case 5:
				System.out.println("enter the id of product you wish to delete");
				id = sc.nextInt();
			   
				if(searchProduct(productArray,id) == -1) {
					System.out.println("no product found");
				}else {
					deleteProduct(productArray,searchProduct(productArray,id));
				}
				break;
				
			case 6:
				System.out.println("Thankyou");
				flag = !flag;
				break;
				
			default:
				System.out.println("INVALID CHOICE");
				break;
			}
			
			
		    
		}while(flag);
		
	}

}
