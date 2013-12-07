package gui.set01.zadanie02_3;

import java.util.ArrayList;

/**
 * Bookshelf
 */
public class Bookshelf {

	protected String name;
	protected Integer size;
	protected ArrayList<Book> shelf;
	protected static ArrayList<Bookshelf> storage = new ArrayList<Bookshelf>();

	/**
	 * @param name
	 * @param size
	 */
	public Bookshelf(String name, Integer size) {

		this.name = name;
		this.size = size;
		shelf = new ArrayList<Book>();
		storage.add(this);
	}

	/**
	 * @return
	 */
	public Book[] getBooks() {
		Book[] output = new Book[shelf.size()];
		return shelf.toArray(output);
	}

	/**
	 * @param book
	 * @throws Exception
	 */
	public void insert(Book book) throws Exception {

		if (shelf.size() >= size) {
			throw new Exception("Nie mogę wstawić książki na półkę (Półka "
					+ name + ") - brak miejsca");
		}

		for (Bookshelf val : storage) {
			for (Book subVal : val.getBooks()) {
				if (book.getAuthor().equals(subVal.getAuthor()) & book.getTitle().equals(subVal.getTitle())) {
					throw new Exception(
							"Nie mogę wstawić książki na półkę (Półka " + name
									+ ") - jest już na półce: Półka "
									+ val.getName());
				}
			}
		}

		shelf.add(book);
	}

	/**
	 * @param book
	 * @throws Exception
	 */
	public void remove(Book book) throws Exception {

		for (Book val : shelf) {
			if (book.getAuthor().equals(val.getAuthor()) && book.getTitle().equals(val.getTitle())) {
				shelf.remove(val);
				return;
			}
		}
		throw new Exception("Nie mogę zdjąć książki z półki (Półka " + name
				+ ") - nie jest na tej półce");
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Półka " + name;
	}

	public String getName() {
		return name;
	}
}
