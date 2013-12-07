package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class ColorChangerGUI2 extends JFrame {

	/**
	 * Obsluga akcji
	 */
	private ActionListener colorChanger = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JComponent src = (JComponent) e.getSource();
			Component comp = (Component) src
					.getClientProperty("ChangeComponent");
			String which = (String) src.getClientProperty("ChooseWhichColor");
			Color fore = (Color) src.getClientProperty("Foreground");
			Color back = (Color) src.getClientProperty("Background");
			if (comp == null)
				return;
			if (which != null) {
				Color color = JColorChooser.showDialog(null, which, null);
				if (color == null)
					return;
				if (which.equals("Foreground"))
					fore = color;
				else
					back = color;
			}
			if (fore != null)
				comp.setForeground(fore);
			if (back != null)
				comp.setBackground(back);
		}
	};

	/**
	 *
	 */
	public ColorChangerGUI2() {

		JLabel lab = new JLabel("Test kolorów");
		lab.setOpaque(true);
		lab.setBorder(BorderFactory.createLineBorder(Color.red));
		lab.setFont(new Font("Dialog", Font.BOLD, 24));
		add(lab);
		JPanel p = new JPanel(new GridLayout(0, 1));
		p.add(cB(lab, "Red on yellow", null, RED, YELLOW));
		p.add(cB(lab, "Blue foreground", null, BLUE, null));
		p.add(cB(lab, "Choose background", "Background", null, null));
		add(p, "West");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Tworzenie przycisków i nadawanie właściwości clientProperty
	 */
	JButton cB(Component target, String txt, String which, Color f, Color back) {

		JButton b = new JButton(txt);
		b.putClientProperty("ChangeComponent", target);
		if (which != null)
			b.putClientProperty("ChooseWhichColor", which);
		if (f != null)
			b.putClientProperty("Foreground", f);
		if (back != null)
			b.putClientProperty("Background", back);
		b.addActionListener(colorChanger);
		return b;
	}

	/**
	 * @param a
	 */
	public static void main(String[] a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ColorChangerGUI2();
			}
		});
	}
}
