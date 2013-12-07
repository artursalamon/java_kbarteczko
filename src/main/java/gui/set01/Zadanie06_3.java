package gui.set01;

import gui.set01.zadanie06_3.Panel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Zad. 3.  Obrazki (max. 10p)
 *
 * Napisać program, który wyświetla kolejno co 5 sekund pliki graficzne
 * znajdujące się w podanym katalogu.
 *
 * Np. jeśli w podanym katalogu znajdują się pliki pool1.jpg, pool2.jpg i bview2.jpg,
 * to w oknie aplikacji mają pojawiać się co 5 sekund kolejne obrazki z tych plików:
 *
 * @author s8376
 */
public class Zadanie06_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String path = "resources/zadanie06_3/";

			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocation(300, 300);
			frame.setPreferredSize(new Dimension(210, 155));

			ArrayList<File> list = new ArrayList<File>();

			File myFile = new File(path);
			for (File file : myFile.listFiles()) {
				list.add(file);
			}

			Panel panel = new Panel(path, list);
			frame.add(panel);
			Thread thread = new Thread(panel);

			frame.pack();
			frame.setVisible(true);

			thread.start();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
