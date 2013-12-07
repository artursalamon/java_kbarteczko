package gui.set01;

import gui.set01.zadanie06_2.Painter;
import gui.set01.zadanie06_2.Parser;

import javax.swing.*;
import java.awt.*;

/**
 * Zad. 2. Wykres paskowy (max. 10 p)
 *
 * Napisać aplikację, która wczytuje plik tekstowy. Aplikacja ma zliczać
 * częstotliwość wystąpienia poszczególnych znaków w pliku i podać wynik
 * graficznie - w postaci wykresu słupkowego, na którym szerokość słupków jest
 * proporcjonalna do częstości występowania znaków, przy czym minimalna częstość
 * jest oznaczana kolorem szarym, maksymalna - czerwonym, a posrednie -
 * niebieskim. Za słupkami na wykresie pokazać liczby, oznaczające odpowiednie
 * częstości.
 *
 * Przetestować aplikację na pliku tekstowym, zawierającym duży fragment
 * polskiego tekstu. Rozwiązanie zadania winno spełniać następujące warunki:
 * zmieniać szerokość słupków wraz z rozmiarami okna aplikacji (wizualizacja
 * najczęsciej występującej litery powinna zawsze mniej więc pokrywać aktualną
 * szerokość okna), zapewnić przewijanie pionowe, gdy liczba "wierszy"
 * wizualizacji nie mieści się w oknie (pomoc: wykorzystać JScrollPane),
 * uwzględniać porządek polskich liter (pomoc: wykorzystać klasę Collator z
 * pakietu java.text).
 *
 * Punktacja:
 *
 * za poprawnie działający program (niekoniecznie spełniający warunki 1-3) - max
 * 3 punkty, za spełnienie warunku 1 - max dodatkowo 2 punkty, za spełnienie
 * warunku 2 - max dodatkowo 2 punkty, za spelnienie warunku 3 - max dodatkowe 3
 * punkty.
 *
 * Przy przydziale punktów będzie uwzględniany sposób oprogramowania
 *
 * @author s8376
 */
public class Zadanie06_2 extends JFrame {

	/**
	 *
	 */
	public Zadanie06_2() {

		try {
			init();
			initGUI();
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}

	/**
	 *
	 */
	public void init() {
		add(new JScrollPane(new Painter(new Parser("resources/zadanie06_2.txt"))),
				BorderLayout.CENTER);
	}

	public void initGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(new Dimension(300, 500));
		setTitle("Wykres");

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Zadanie06_2();
			}
		});
	}
}
