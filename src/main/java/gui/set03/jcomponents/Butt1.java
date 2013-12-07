package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.*;

/**
 * IconA
 */
class IconA implements Icon {

	private Color color;
	private int w = 40;
	private boolean frame;

	/**
	 * @param c
	 * @param frame
	 */
	IconA(Color c, boolean frame) {
		color = c;
		this.frame = frame;
	}

	/**
	 * @param c
	 * @param g
	 * @param x
	 * @param y
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {

		Color old = g.getColor();
		g.setColor(color);
		w = ((JComponent) c).getHeight() / 2;
		int p = w / 4, d = w / 2;
		g.fillOval(x + p, y + p, d, d);
		if (frame)
			g.drawRect(x, y, w - 1, w - 1);
		g.setColor(old);
	}

	public int getIconWidth() {
		return w;
	}

	public int getIconHeight() {
		return w;
	}

}

/**
 * Butt1
 */
public class Butt1 extends JFrame {

	private Icon[] icons = {new IconA(Color.yellow, false), // normal
			new IconA(Color.blue, false), // over
			new IconA(Color.red, true), // pressed
			new IconA(Color.black, false), // selected
	};

	// przycisk, który bedzie programistycznie wciśnięty
	private JButton bpre = new JButton("Button - pressed");

	/**
	 *
	 */
	Butt1() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setLayout(new GridLayout(0, 1, 10, 10));
				JButton b = new JButton("Button");
				setButt(b, icons, RIGHT, CENTER);
				JButton bmov = new JButton("Button - mouse over");
				setButt(bmov, icons, LEFT, TOP);
				setButt(bpre, icons, CENTER, TOP);

				JToggleButton tb = new JToggleButton("ToggleButton - selected");
				setButt(tb, icons, CENTER, BOTTOM);

				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				pack();
				setLocationRelativeTo(null);
				setVisible(true);
			}
		});
		bpre.doClick(5000);
	}

	/**
	 * @param b
	 * @param i
	 * @param horPos
	 * @param vertPos
	 */
	void setButt(AbstractButton b, Icon[] i, int horPos, int vertPos) {

		b.setFocusPainted(false);
		b.setIcon(i[0]);
		b.setRolloverIcon(i[1]);
		b.setPressedIcon(i[2]);
		b.setSelectedIcon(i[3]);
		b.setHorizontalTextPosition(horPos);
		b.setVerticalTextPosition(vertPos);
		add(b);
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		new Butt1();
	}
}
