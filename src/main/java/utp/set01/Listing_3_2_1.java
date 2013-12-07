package utp.set01;

import java.lang.reflect.Method;

/**
 * Para
 *
 * @param <S>
 * @param <T>
 */
class Para<S, T> {

	static int nr;
	S first;
	T last;

	public static int getNr() {
		return nr;
	}

	public Para(S f, T l) {
		first = f;
		last = l;
		nr++;
	}

	public S getFirst() {
		return first;
	}

	public T getLast() {
		return last;
	}

	public void setFirst(S f) {
		first = f;
	}

	public void setLast(T l) {
		last = l;
	}
}

/**
 * Listing_3_2_1
 */
public class Listing_3_2_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Para<String, Integer> p1 = new Para<String, Integer>("Ala", 3);
		System.out.println(p1.getNr());
		Para<String, Integer> p2 = new Para<String, Integer>("Ala", 3);
		System.out.println(p2.getNr());
		Para<String, String> p3 = new Para<String, String>("Ala", "Kowalska");
		System.out.println(p3.getNr());

		// Co jest - tylko klasa Para
		// "Raw Type"

		Class p1Class = p1.getClass();
		System.out.println(p1Class);

		// Metodami refleksji możemy się przekonać, że
		// w definicji klasy Para typem fazy wykonania dla parametrów jest Object
		// "type erasure"!!!

		Method[] mets = p1Class.getDeclaredMethods(); // zwraca tablicę metod deklarwoanych w klasie
		for (Method m : mets)
			System.out.println(m);

		// Surowego typu ("Raw Type") możemy też używać
		// ale czasem wiąże się to z niuansami
		// i kompilator może nas ostrzegać o możliwych błędach

		Para p = new Para("B", new Double(3.1));
		String f = (String) p.getFirst();
		double d = (Double) p.getLast();
		System.out.println(f + " " + d);
	}
}
