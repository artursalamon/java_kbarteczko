package gui.set03.table;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * CarApp
 */
public class CarApp {

	private TableGUI<CarTabModel, Car> gui;

	/**
	 *
	 */
	public CarApp() {

		Class kl = getClass();
		ImageIcon icon = new ImageIcon(kl.getResource("images/lockkey.gif"));

		List<Car> clist = Arrays.asList(new Car[]{
				new Car("Plymouth", "Barracuda", 1970, 300, new ImageIcon(kl
						.getResource("images/plym.jpeg"))),
				new Car("Lamborghini", "Murcielago", 2007, 1000, new ImageIcon(
						kl.getResource("images/lamborghini.jpeg"))),
				new Car("Jeep", "Cherokee", 1997, 6, icon),
				new Car("Jeep", "Cherokee", 2001, 12, icon),
				new Car("Fiat", "Spider", 1982, 40, icon),
				new Car("Fiat", "Bravo", 2005, 40, icon),
				new Car("Mitsubishi", "Galant", 2007, 80, new ImageIcon(kl
						.getResource("images/mitsubishi.jpg"))),});

		// Nazwy kolumn
		String[] colNames = {"Marka", "Model", "Rocznik", "Cena", "Foto"};
		// Utworzenie modelu danych
		CarTabModel model = new CarTabModel(clist, colNames);

		gui = new TableGUI<CarTabModel, Car>("Aplikacja tablicowa - samochody",
				model);

		gui.getTable().setRowHeight(70);
		gui.getTable().getColumn("Foto").setWidth(70);

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
				new CarApp();
			}
		});
	}
}
