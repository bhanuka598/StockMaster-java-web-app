package stock_management_system_package;

public class Purchase_Model {
	private int purchase_id;
	private String product_id;
	private String supplier_id;
	private String purchase_date;
	private String quantity;
	private String purchase_price;
	private String total_cost;
	
	public Purchase_Model(int purchase_id, String product_id, String supplier_id, String purchase_date, String quantity,
			String purchase_price, String total_cost) {
		super();
		this.purchase_id = purchase_id;
		this.product_id = product_id;
		this.supplier_id = supplier_id;
		this.purchase_date = purchase_date;
		this.quantity = quantity;
		this.purchase_price = purchase_price;
		this.total_cost = total_cost;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(String purchase_price) {
		this.purchase_price = purchase_price;
	}

	public String getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(String total_cost) {
		this.total_cost = total_cost;
	}
	
	
}
