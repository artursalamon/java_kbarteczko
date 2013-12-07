package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * EvSelection
 */
public class EvSelection extends JFrame implements ActionListener {

	JTextField tfFirstName = new JTextField(20); //  pole imienia
	JTextField tfLastName = new JTextField(20); //  pole nazwiska
	JComponent cp = (JComponent) getContentPane();

	/**
	 *
	 */
	public EvSelection() {

		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		cp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		tfLastName.setActionCommand("Szukaj"); // nazwa akcji na polu nazwisko
		tfLastName.addActionListener(this);

		addNamePanel("Imię", tfFirstName); //  dla uproszczenia kodu stworzono
		addNamePanel("Nazwisko", tfLastName); // metodę addNamePanel - zob. dalej

		JPanel p = new JPanel(); // do tego panelu dodajemy przyciski
		String[] cmd = {"Dodaj", "Szukaj", "Usuń"};
		final boolean[] warn = {false, false, true}; // które z nich mają być
		// podświetlane?
		for (int i = 0; i < cmd.length; i++) {
			JButton b = new JButton(cmd[i]);
			b.addActionListener(this);
			//------------------------------------------------ obsługa zdarzeń myszki
			if (warn[i])
				b.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) { // wejście w obszar komponentu
						JComponent c = (JComponent) e.getSource();
						c.putClientProperty("OldColor", c.getBackground());// zapisujemy kolor
						c.setBackground(Color.orange); // ustalamy kolor ostrzegawczy
					}

					public void mouseExited(MouseEvent e) { // wyjście z obszaru komponentu
						JComponent c = (JComponent) e.getSource();
						c
								.setBackground((Color) c
										.getClientProperty("OldColor")); // odtwarzamy kolor
					}
				});
			//------------------------------------------------------------------------
			p.add(b);
		}
		cp.add(p);
		pack();
		show();
	}

	/**
	 * @param lab
	 * @param tf
	 */
	void addNamePanel(String lab, JTextField tf) {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel l = new JLabel(lab);
		l.setPreferredSize(new Dimension(70, 20));
		l.setHorizontalAlignment(JLabel.RIGHT);
		p.add(l);
		p.add(tf);
		cp.add(p);
	}

	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("Akcja: " + e.getActionCommand());
	}

	/**
	 * @param a
	 */
	public static void main(String[] a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EvSelection();
			}
		});
	}
}
