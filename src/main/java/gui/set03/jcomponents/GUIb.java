package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
class GUIb extends JFrame {

	final int BNUM = 3; // liczba przycisków

	/**
	 *
	 */
	GUIb() {

		super("GUI");
		setLayout(new FlowLayout());
		for (int i = 1; i <= BNUM; i++) {
			JButton b = new JButton("Przycisk " + i);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Wystąpiło zdarzenie!");
				}
			});
			add(b);
		}
		pack();
		show();
	}

	/**
	 * @param a
	 */
	public static void main(String[] a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIb();
			}
		});
	}
}
