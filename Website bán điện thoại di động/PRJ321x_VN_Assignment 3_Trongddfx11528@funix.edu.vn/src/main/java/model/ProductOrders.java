package model;

public class ProductOrders {
	 private int id;
	 private String nameProduct;
     private float price;
     private int amountProduct;//quantity of selected product
     private float Totalprice;
	public ProductOrders(int id, String nameProduct, float price, int amountProduct) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.price = price;
		this.amountProduct = amountProduct;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}
	public float getTotalprice() {
		return price*amountProduct;
	}
	public void setTotalprice(float totalprice) {
		Totalprice = totalprice;
	}
	
}
	