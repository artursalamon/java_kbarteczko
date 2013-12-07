package gui.set01.zadanie03_5;

/**
 * Product
 */
abstract public class Product {

	private String name;
	private double quantity;

	/**
	 * @param name
	 * @param quantity
	 */
	public Product(String name, double quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
