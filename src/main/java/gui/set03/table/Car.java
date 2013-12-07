package gui.set03.table;

import javax.swing.*;

/**
 * Car
 */
public class Car {

	private String make;
	private String model;
	private Integer year;
	private Integer price;
	private Icon icon;

	/**
	 * @param make
	 * @param model
	 * @param year
	 * @param price
	 * @param icon
	 */
	public Car(String make, String model, Integer year, Integer price, Icon icon) {

		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.icon = icon;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}
}
