package gui.set03.jcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ColorChanger
 */
public class ColorChanger implements ActionListener {

	private Component comp; // jakiego komponentu dotyczy zmiana koloru
	private Color fore, back; // ustawiane kolory: pierwszy plan, tło
	private String which; // jeśli nie podano dwóch kolorów - which powie, ktory

	/**
	 * chcemy zmieniać
	 * Będziemy chcieli zmieniać oba kolory na podanym komponencie
	 *
	 * @param c
	 * @param f
	 * @param b
	 */
	public ColorChanger(Component c, Color f, Color b) {
		comp = c;
		fore = f;
		back = b;
	}


	/**
	 * Będziemy chcieli zmieniać tylko jeden kolor.
	 * Który – powie parametr which
	 *
	 * @param c
	 * @param which
	 * @param color
	 */
	public ColorChanger(Component c, String which, Color color) {
		comp = c;
		if (which.equals("Foreground"))
			fore = color;
		else
			back = color;
	}

	/**
	 * Nie podaliśmy koloru do ustalenia.
	 * Wykorzystamy dialog JColorChooser
	 *
	 * @param c
	 * @param which
	 */
	public ColorChanger(Component c, String which) {
		comp = c;
		this.which = which;
	}

	/**
	 * Obsługa akcji
	 *
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {

		if (fore == null && back == null) { // oznacza, że mamy skorzystać z
			// JColorChoosera
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
}
