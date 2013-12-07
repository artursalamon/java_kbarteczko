package gui.set01;

import gui.set01.zadanie05_3.Graph;

import javax.swing.*;
import java.awt.*;

/**
 * Zadanie 3 - Rysowanie na komponencie - obraz w ramce z podpisem
 *
 * Napisz program,który umieszcza na pulpicie obraz z pliku  * .gif, *.jpg  itp.,
 * centruje go na pulpicie, w odległości  1/4 wysokości obrazu otacza ramką
 * o grubości  1/10 szerokości  obrazu, którą wypełnia kolorem  różnym od tła.
 * W prostokącie między dolną krawędzią obrazu a ramką dokonuje podpisu  obrazu
 * pismem pochyłym (italic) .
 *
 * @author s8376
 */
public class Zadanie05_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("Obrazek");

		Graph graph = new Graph("resources/images/zadanie05_3a.jpg");
		frame.getContentPane().add(graph);

		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2
				- frame.getHeight() / 2);

		frame.setVisible(true);
	}
}
