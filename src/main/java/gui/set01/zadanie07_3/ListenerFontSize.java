package gui.set01.zadanie07_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ListenerFontSize
 *
 * @author s8376
 */
public class ListenerFontSize implements ActionListener {

	protected JTextArea handler;
	protected int fontSize;

	/**
	 * @param handler
	 * @param size
	 */
	public ListenerFontSize(JTextArea handler, int size) {
		this.handler = handler;
		this.fontSize = size;
	}

	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		handler.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
	}
}
