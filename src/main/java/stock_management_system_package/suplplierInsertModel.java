package stock_management_system_package;

public class suplplierInsertModel {
	private int supplier_id;
    private String supplier_name;
    private String contact_person;
    private String email;
    private String phone;
    public suplplierInsertModel(int supplier_id, String supplier_name, String contact_person, String email,String phone, String address) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.contact_person = contact_person;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
    
}