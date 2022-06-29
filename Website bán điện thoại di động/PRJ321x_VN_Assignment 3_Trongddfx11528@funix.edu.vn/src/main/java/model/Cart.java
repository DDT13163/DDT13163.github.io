package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<ProductOrders> items;//list of item in cart
    public Cart() {
    	items = new ArrayList<>();
    }
    
    //add a new product to cart
    public void add(ProductOrders ci) {
    	for (ProductOrders x: items) {
    		if (ci.getId() == x.getId()) {
    			x.setAmountProduct(x.getAmountProduct() + 1);
    			return;
    		}
    	}
    	items.add(ci);
    }
    //remove a product from cart
    public void remove(int id) {
    	for (ProductOrders x: items) {
    		if (x.getId() == id) {
    		items.remove(x);
    		return;
    	}
      }
    }   
   //return total amount of cart
    public double getAmount() {
    	double s = 0;
    	for (ProductOrders x: items) {
    		s += x.getPrice() * x.getAmountProduct();
    	}
    	return (double)Math.round(s * 100)/100;
    }
   //return list of products in cart
    public List<ProductOrders> getItems() {
    	return items;
    }
}