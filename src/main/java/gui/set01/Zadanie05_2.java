package gui.set01;

import gui.set01.zadanie05_2.Graph;

import javax.swing.*;

/**
 * Zadanie 2  - Rysowanie na komponencie - wymiarowanie proporcjonalne
 *
 * Figury geometryczne z zadania 1 wyrysować tak aby zmieniały wymiary
 * proporcjonalnie do wymiarów panelu do rysowania.
 *
 * @author s8376
 */
public class Zadanie05_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("Rysowanie ");
		Graph graph = new Graph();
		frame.getContentPane().add(graph);
		frame.setLocation(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
