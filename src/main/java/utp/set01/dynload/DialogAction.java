package utp.set01.dynload;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * DialogAction
 */
public class DialogAction extends AbstractAction {

	final static String ACTION_NAME = "Show msg";

	/**
	 *
	 */
	public DialogAction() {
		super(ACTION_NAME);
	}

	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, ACTION_NAME);
	}
}
