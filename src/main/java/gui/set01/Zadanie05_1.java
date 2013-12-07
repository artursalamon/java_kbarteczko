package gui.set01;

import gui.set01.zadanie05_1.Graph;

import javax.swing.*;

/**
 * Zadanie 1  - Rysowanie na komponencie - wymiarowanie w pikslach
 *
 * Poniższy kod programu generuje okno ramowe aplikacji i na panelu wstawionym
 * do okna rysuje i wypełnia prostą figurę geometryczną.
 *
 * // Rysowanie na komponencie
 * // Na komponencie mozna rysowac i wypelniac:
 * // proste figury geometryczne,napisy,obrazy (umozliwiaja to metody klasy Graphics);
 * // w ciele metody paintComponent() mamy dostep do obiektu wykreslajacego klasy Graphics
 *
 * import java.util.*;
 * import java.awt.*;
 * import javax.swing.*;
 *
 * class Graph extends JPanel {
 * int dim = 20;  //srednica figury
 * int x = 75, y = 75; //polozenie
 * public void paintComponent(Graphics g){
 * super.paintComponent(g); //wykreslanie komponentu JPanel
 * g.setColor(Color.blue); //ustawienie koloru wykreslania
 * g.fillOval(x, y, dim, dim); //wypelnianie kola
 * }
 * public Dimension getPreferredSize(){
 * return new Dimension(200, 200);
 * }
 * }
 * class Main {
 * public static void main(String[] args){
 * JFrame frame = new JFrame("Rysowanie ");//utworzenie okna ramowego
 * Graph graph  = new Graph(); //utworzenie panelu do rysowania
 * frame.getContentPane().add(graph); //dodanie panelu do okna ramowego
 * frame.setLocation(300, 300); //lokalizacja okna na ekranie
 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //obsługa zamkniecia okna
 * frame.pack(); //upakowanie okna
 * frame.show(); //wyswietlenie okna na ekranie
 * }
 * }
 *
 * Uruchomić ten program i zaobserwować jego działanie (wpływ parametrów panelu i figur).
 *
 * Po zapoznaniu z dokumentacją klasy Graphics:
 *
 * wyrysować i ewentualnie wypełnić inne figury geometryczne o wymiarach podanych w pikslach:
 * - linię, prostokąt, trójkąt,wycinek koła
 * - wyrysować określony napis w odpowiednim położeniu
 * - wyrysować obraz z pliku graficznego
 *
 * Zoabserwować czy wymiary figur zmieniają sie przy zmianach rozmiaru okienka aplikacji
 *
 * @author s8376
 */
class Zadanie05_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("Rysowanie ");//utworzenie okna ramowego
		Graph graph = new Graph(); //utworzenie panelu do rysowania
		frame.getContentPane().add(graph); //dodanie panelu do okna ramowego
		frame.setLocation(300, 300); //lokalizacja okna na ekranie
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //obsługa zamkniecia okna
		frame.pack(); //upakowanie okna
		frame.show(); //wyswietlenie okna na ekranie
	}
}
