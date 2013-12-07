package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

/**
 * GUI3
 */
public class GUI3 extends JFrame implements ActionListener {

	String[] ctab = {"Red", "Yellow", "Blue"};
	Color[] color = {RED, YELLOW, BLUE};

	/**
	 *
	 */
	public GUI3() {

		super("GUI");
		setLayout(new FlowLayout());

		for (int i = 0; i < ctab.length; i++) {
			JButton b = new JButton(ctab[i]);
			b.setActionCommand("" + i);
			b.addActionListener(this);
			add(b);
		}
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		int index = Integer.parseInt(e.getActionCommand());
		getContentPane().setBackground(color[index]);
	}

	/**
	 * @param a
	 */
	public static void main(String[] a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI3();
			}
		});
	}
}
