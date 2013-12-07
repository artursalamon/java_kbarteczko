package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * ColorChangerGUI
 */
public class ColorChangerGUI extends JFrame {

	/**
	 *
	 */
	ColorChangerGUI() {

		JLabel lab = new JLabel("Test kolorów");
		lab.setOpaque(true);
		lab.setBorder(BorderFactory.createLineBorder(Color.red));
		lab.setFont(new Font("Dialog", Font.BOLD, 24));
		add(lab);

		JPanel p = new JPanel(new GridLayout(0, 1));
		JButton b = new JButton("Red on yellow");
		b.addActionListener(new ColorChanger(lab, RED, YELLOW));
		p.add(b);

		b = new JButton("Blue foreground");
		b.addActionListener(new ColorChanger(lab, "Foreground", BLUE));
		p.add(b);

		b = new JButton("Choose background");
		b.addActionListener(new ColorChanger(lab, "Backround"));
		p.add(b);

		add(p, "West");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param a
	 */
	public static void main(String[] a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ColorChangerGUI();
			}
		});
	}
}
