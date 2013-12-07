package gui.set01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Zadanie 2 (max 4 punkty)
 *
 * W oknie umieszczone są dwa przyciski z napisami "Przycisk 1" i "Przycisk 2".
 *
 * Kliknięcie w każdy z nich zwiększa rozmiar pisma na przycisku o 1 pkt.
 *
 * Zapewnić:
 * aby zmiany pisma były widoczne natychmiast na przyciskach,
 * aby zawsze w oknie były widoczne oba całe  przyciski (niedopuszczalne jest,
 * by na skutek zwiększenia pisma w oknie była widoczna tylko część przycisku).
 *
 * @author s8376
 */
public class Zadanie07_2 extends JFrame implements ActionListener {

	JButton button1, button2;

	/**
	 *
	 */
	Zadanie07_2() {

		super("GUI Zadanie 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(160, 110));
		setLocation(200, 200);
		setLayout(new FlowLayout());

		Font font = new Font("Dialog", Font.PLAIN, 12);

		button1 = new JButton("Przycisk 1");
		button1.setFont(font);
		button1.addActionListener(this);
		add(button1);

		button2 = new JButton("Przycisk 2");
		button2.setFont(font);
		button2.addActionListener(this);
		add(button2);

		setSize(getDimension());

		pack();
		setVisible(true);
	}

	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		JButton handler = (JButton) e.getSource();
		Font font = new Font("Dialog", 0, handler.getFont().getSize() + 1);
		button1.setFont(font);
		button2.setFont(font);

		setSize(getDimension());
	}

	/**
	 * @return
	 */
	Dimension getDimension() {
		return new Dimension(button1.getWidth() + button2.getWidth() + 20,
				button1.getHeight() + button2.getHeight() + 60);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Zadanie07_2();
			}
		});
	}
}
