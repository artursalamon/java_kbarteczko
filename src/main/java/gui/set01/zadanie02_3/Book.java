package gui.set01.zadanie02_3;

/**
 * Book
 */
public class Book {

	protected String author;
	protected String title;

	/**
	 * @param author
	 * @param title
	 */
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return author + " " + title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
