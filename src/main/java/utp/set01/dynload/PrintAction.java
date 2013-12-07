package utp.set01.dynload;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * PrintAction
 */
public class PrintAction extends AbstractAction {

	final static String ACTION_NAME = "Print";

	/**
	 *
	 */
	public PrintAction() {
		super(ACTION_NAME);
	}

	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("Wykonan akcja: " + ACTION_NAME);
	}
}
