
public class Product {
      
    private long id;
    private String name;
    private long quantity;
    private long pricePerUnit;
    
    // default constructor
	public Product() {
		super();
	}
    
	
	//parameterized constructor
	public Product(long id, String name, long quantity, long pricePerUnit) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	// setting and getting id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// setting and gettting name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
  
	// setting and getting quantity
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	//setting and getting price
	public long getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(long pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
    
    
    
}
