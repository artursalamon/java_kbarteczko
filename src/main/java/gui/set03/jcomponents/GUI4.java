package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

/**
 *
 */
public class GUI4 extends JFrame implements ActionListener {

	/**
	 *
	 */
	public GUI4() {

		super("GUI");
		setLayout(new FlowLayout());
		add(createButton("Red", RED, this));
		add(createButton("Yellow", YELLOW, this));
		add(createButton("Blue", BLUE, this));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}


	/**
	 * Metoda tworzy przycisk z podanym tekstem i jego kolorem
	 * Przyłącza też przekazany ActionListenr
	 *
	 * @param s
	 * @param c
	 * @param al
	 * @return
	 */
	JButton createButton(String s, Color c, ActionListener al) {

		JButton b = new JButton(s);
		b.setForeground(c);
		b.addActionListener(al);
		return b;
	}

	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		Component b = (Component) e.getSource(); // Uwaga: getSource zwraca Object
		getContentPane().setBackground(b.getForeground()); // rzutujemy do Component, by wywołać getForeground()
	}

	/**
	 * @param a
	 */
	public static void main(String[] a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI4();
			}
		});
	}
}
