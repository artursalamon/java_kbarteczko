package gui.set03.table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tab1
 */
public class Tab1 extends JFrame implements ActionListener {

	/**
	 *
	 */
	public Tab1() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Dane przykładowej tabeli
		Object[][] data = {{"Chopin Fryderyk", "M", 1789},
				{"Kopernik Mikołaj", "M", 2900},
				{"Słowacki Juliusz", "M", 2000},
				{"Szymborska Wisława", "K", 5200},
				{"Polański Roman", "M", 3000},
				{"Skłodowska-Curie Maria", "K", 2000},
				{"Modrzejewska Helena", "K", 2000},};
		// Nazwy kolumn
		String[] columnNames = {"Nazwisko i imię", "Płeć", "Pensja"};

		JTable tab = new JTable(data, columnNames);
		tab.setAutoCreateRowSorter(true);
		add(new JScrollPane(tab));

		pack();
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Tab1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
