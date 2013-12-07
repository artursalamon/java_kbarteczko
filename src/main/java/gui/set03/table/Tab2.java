package gui.set03.table;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Tab2
 */
public class Tab2 extends JFrame {

	/**
	 *
	 */
	public Tab2() {

		Object[][] data = {{"Chopin Fryderyk", "M", 1789},
				{"Chopin Fryderyk", "M", 3000},
				{"Kopernik Mikołaj", "M", 2900},
				{"Słowacki Juliusz", "M", 2000},
				{"Szymborska Wisława", "K", 3200},
				{"Polański Roman", "M", 3000},
				{"Skłodowska-Curie Maria", "K", 2000},
				{"Skłodowska-Curie Maria", "K", 3000},
				{"Modrzejewska Helena", "K", 2000},};
		String[] columnNames = {"Nazwisko i imię", "Płeć", "Pensja"};

		final JTable tab = new JTable(data, columnNames);
		tab.setAutoCreateRowSorter(true);

		final JTextArea report = new JTextArea(20, 40);

		// Nasłuch kliknięć w kolumny
		tab.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTableHeader head = (JTableHeader) e.getSource();
				int col = head.columnAtPoint(e.getPoint());
				report.append("Kliknięcie w kolumnę '" + tab.getColumnName(col)
						+ "'\\\\nDane posortowane wg:\\\\n");
				TableRowSorter tsorter = (TableRowSorter) tab.getRowSorter();
//                List<SortKey> sortKeys = tsorter.getSortKeys();
//                for (SortKey key : sortKeys) {
//                    report.append("-- " + tab.getColumnName(key.getColumn())
//                            + " w porządku " + key.getSortOrder() + "\\\\n");
//                }

			}
		});

		tab.setPreferredScrollableViewportSize(tab.getPreferredSize());
		add(new JScrollPane(tab), "North");
		add(new JScrollPane(report));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Tab2();
	}
}
