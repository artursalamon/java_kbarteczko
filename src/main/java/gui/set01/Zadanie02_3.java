package gui.set01;

import gui.set01.zadanie02_3.Book;
import gui.set01.zadanie02_3.Bookshelf;

/**
 * Zadanie 3
 *
 * Mamy półki. Każda półka ma swoją nazwę i rozmiar (liczbę książek, które
 * może pomieścić)
 * Mamy książki. Opis książki to: autor, tytuł.
 * Inicjalnie każda książka jest poza jakąkolwiek półką.
 * Można ją wstawić na wybraną półkę, albo zdjąć z półki, na której się znajduje.
 *
 * Zaprojektuj klasy Book i Bookshelf, opisujące książki i półki w taki sposób,
 * aby następujący program:
 *
 * public class TestBook {
 *
 *
 * public static void main(String[] args) {
 * Book b1 = new Book("A", "bbb");
 * Book b2 = new Book("B", "ccc");
 * Book b3 = new Book("C", "ddd");
 *
 * Bookshelf bs1 = new Bookshelf("P1", 10);
 * Bookshelf bs2 = new Bookshelf("P2", 2);
 *
 * try {
 * bs1.insert(b1);
 * bs1.insert(b2);
 * bs1.insert(b3);
 *
 * System.out.println(bs1);
 * for (Book b : bs1.getBooks()) System.out.println(b);
 *
 * bs2.insert(b1);
 * } catch (Exception exc) {
 * System.out.println(exc.getMessage());
 * }
 *
 * try {
 * for (Book b : bs1.getBooks()) bs1.remove(b);
 * bs2.insert(b1);
 * bs2.insert(b2);
 *
 * System.out.println(bs2);
 * for (Book b : bs2.getBooks()) System.out.println(b);
 *
 * bs2.insert(b3);
 * } catch (Exception exc) {
 * System.out.println(exc.getMessage());
 * }
 *
 * try {
 * bs2.remove(b3);
 * } catch (Exception exc) {
 * System.out.println(exc.getMessage());
 * }
 * }
 *
 * }
 *
 * wyprowadził następujące wyniki:
 *
 * Półka P1
 * A bbb
 * B ccc
 * C ddd
 * Nie mogę wstawić książki na półkę (Półka P2) - jest już na półce: Półka P1
 * Półka P2
 * A bbb
 * B ccc
 * Nie mogę wstawić książki na półkę (Półka P2) - brak miejsca
 * Nie mogę zdjąć książki z półki (Półka P2) - nie jest na tej półce
 *
 * Użyj wbudowanych klas kolekcyjnych tak aby program był krótki i prosty w kodowaniu.
 *
 * @author s8376
 */
public class Zadanie02_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Book b1 = new Book("A", "bbb");
		Book b2 = new Book("B", "ccc");
		Book b3 = new Book("C", "ddd");

		Bookshelf bs1 = new Bookshelf("P1", 10);
		Bookshelf bs2 = new Bookshelf("P2", 2);

		try {
			bs1.insert(b1);
			bs1.insert(b2);
			bs1.insert(b3);

			System.out.println(bs1);
			for (Book b : bs1.getBooks())
				System.out.println(b);

			bs2.insert(b1);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}

		try {
			for (Book b : bs1.getBooks())
				bs1.remove(b);
			bs2.insert(b1);
			bs2.insert(b2);

			System.out.println(bs2);
			for (Book b : bs2.getBooks())
				System.out.println(b);

			bs2.insert(b3);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}

		try {
			bs2.remove(b3);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}
}
