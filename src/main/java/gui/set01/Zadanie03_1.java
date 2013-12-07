package gui.set01;

import gui.set01.zadanie03_1.Int;
import gui.set01.zadanie03_1.Sortable;
import gui.set01.zadanie03_1.Str;

/**
 * Zadanie 1
 *
 * Zdefiniuj w programie interfejs
 *
 * interface Sortable{
 * int compare(Object obj1,Object obj2);
 * }
 *
 * deklarujący metodę int compare(Object obj1,Object obj2) porównującą dwa
 * obiekty i zwracającą w konkretnej implementacji
 *
 * * liczbę ujemną jeżeli obj1 < obj2
 * * liczbę równą zeru jeżeli obj1==object2
 * * liczbe dodatnią jeżeli obj1>obj2
 *
 * Zdefiniuj również klasę
 *
 * class Str implements Sortable {
 * private String name;
 * .......
 * }
 *
 * oraz klasę
 *
 * class Int implements Sortable{
 * private int x;
 * .....
 * }
 *
 * tak aby poniższy test
 *
 * class TestInter {
 * public static void main(String args[]) {
 * Sortable sort=new Str();
 * Sortable sort1=null;
 * Sortable sort2=null;
 * sort1=new Str("kot");
 * sort2=new Str("ala");
 *
 * System.out.println("----- porównywanie łańcuchów-----");
 * System.out.println(sort.compare(sort1,sort2)); //wywołanie polimorficzne
 *
 * sort=new Int();
 * sort1=new Int(230);
 * sort2=new Int(5);
 *
 * System.out.println("----- porównywanie liczb-----");
 * System.out.println(sort.compare(sort1,sort2)); //wywołanie polimorficzne
 * }
 * }//class TestInter
 *
 * dał wynik nastepujący:
 *
 * "----- porównywanie łańcuchów-----"
 * 10
 * "----- porównywanie liczb-----"
 * 1
 *
 * Wskazówka :  zastanów się
 * * jak ma wylądać implementacja metody compare(...) w klasach Str i Int
 * * jakie konstruktory powinny posiadać te klasy ?
 * * dlaczego wskazane wywołania są polimorficzne ?
 *
 * @author s8376
 */
public class Zadanie03_1 {

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		Sortable sort = new Str();

		Sortable sort1 = null;
		Sortable sort2 = null;

		sort1 = new Str("kot");
		sort2 = new Str("ala");

		System.out.println("----- porównywanie łańcuchów-----");

		System.out.println(sort.compare(sort1, sort2)); //wywołanie polimorficzne

		sort = new Int();

		sort1 = new Int(230);
		sort2 = new Int(5);

		System.out.println("----- porównywanie liczb-----");

		System.out.println(sort.compare(sort1, sort2)); //wywołanie polimorficzne
	}
}
