package stock_management_system_package;

public class Salesinsert_model {
	
	private int sales_id;
	private String product_name;
	private String customer_name;
	private int quantity;
	private float unit_price;
	private String sale_date;
	private float total_amount;
	public Salesinsert_model(int sales_id, String product_name, String customer_name, int quantity,
			float unit_price, String sale_date, float total_amount) {
		super();
		this.sales_id = sales_id;
		this.product_name = product_name;
		this.customer_name = customer_name;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.sale_date = sale_date;
		this.total_amount = total_amount;
	}
	public int getSales_id() {
		return sales_id;
	}
	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	
	
	
}
