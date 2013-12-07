package gui.set03.layouts;

import javax.swing.*;
import java.awt.*;

/**
 * GuiSwing
 */
public class GuiSwing extends JFrame {

	/**
	 *
	 */
	public GuiSwing() {

		// jakieś dzialania inicjacyjne, nie związane z komponentami Swing
		// ...

		// budujemy okno;
		// ponieważ jest to działanie na komponentach wizualnych
		// - zrobimy to w wątku obsługi zdarzeń
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createGui();
			}
		});
	}

	/**
	 *
	 */
	protected void createGui() {

		// ustalenie tytułu okna
		setTitle("Okno aplikacji");

		// ustalenie rozkładu - jeśli trzeba, np:
		setLayout(new FlowLayout());

		// tworzenie komponentów np.
		JLabel lab = new JLabel("Etykieta");
		JButton b = new JButton("Przycisk");

		// Ustalenie własciwości komponentów,
		// np:
		lab.setForeground(Color.red);
		b.setForeground(Color.blue);

		// Dodanie komponentów do okna np.
		add(lab);
		add(b);

		// Ustalenie domyślnej operacji zamknięcia okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ustalenie rozmiarów okna, np.:
		pack();

		// ustalenie położenia okna np. wycentrowanie

		setLocationRelativeTo(null);

		// pokazanie okna
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GuiSwing();
	}
}
