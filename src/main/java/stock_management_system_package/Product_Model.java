package stock_management_system_package;

public class Product_Model {
	private int product_id;
	private String product_name;
	private String category;
	private String stock_quantity;
	private String price;
	
	public Product_Model(int product_id, String product_name, String category, String stock_quantity, String price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.stock_quantity = stock_quantity;
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(String stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


}
