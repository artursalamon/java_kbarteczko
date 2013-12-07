package gui.set01.zadanie08_2;

import javax.swing.*;

/**
 * Book
 *
 * @author s8376
 */
public class Book {

	int id;
	float price;
	String authorName, publishingHouse, title;
	ImageIcon frontpageImage;

	/**
	 * @param id
	 * @param authorName
	 * @param title
	 * @param publishingHouse
	 * @param price
	 * @param frontpageImage
	 */
	public Book(int id, String authorName, String title,
	            String publishingHouse, float price, ImageIcon frontpageImage) {

		this.id = id;
		this.price = price;
		this.authorName = authorName;
		this.publishingHouse = publishingHouse;
		this.title = title;
		this.frontpageImage = frontpageImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ImageIcon getFrontpageImage() {
		return frontpageImage;
	}

	public void setFrontpageImage(ImageIcon frontpageImage) {
		this.frontpageImage = frontpageImage;
	}
}
