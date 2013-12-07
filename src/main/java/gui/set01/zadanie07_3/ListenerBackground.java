package gui.set01.zadanie07_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ListenerBackground
 *
 * @author s8376
 */
public class ListenerBackground implements ActionListener {

	protected JTextArea handler;

	/**
	 * @param handler
	 */
	public ListenerBackground(JTextArea handler) {
		this.handler = handler;
	}

	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		MyIcon icon = (MyIcon) item.getIcon();
		handler.setBackground(icon.getColor());
	}
}
