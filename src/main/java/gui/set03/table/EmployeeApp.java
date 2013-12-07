package gui.set03.table;

import javax.swing.*;
import java.util.List;

/**
 * EmployeeApp
 */
public class EmployeeApp {

	private TableGUI<EmpTabModel, Employee> gui;

	/**
	 *
	 */
	public EmployeeApp() {

		// Metoda genarate tworzy w sposób losowy lisę pracowników
		// tu o rozmiarze 100 elementów
		List<Employee> elist = Employee.generate(100);

		// Nazwy kolumn
		String[] colNames = {"Nazwisko i imię", "Adres", "Data urodzenia",
				"Pensja"};

		// Utworzenie modelu danych
		EmpTabModel model = new EmpTabModel(elist, colNames);

		// Utworzenie GUI
		gui = new TableGUI<EmpTabModel, Employee>(
				"Aplikacja tablicowa - pracownicy", model);

//        gui.setSpecialsPopupMenu(specialActions);
		gui.pack();
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EmployeeApp();
			}
		});
	}

}
