package gui.set01;

import gui.set01.zadanie05_4.CaseA;
import gui.set01.zadanie05_4.CaseB;
import gui.set01.zadanie05_4.CaseC;

import javax.swing.*;

/**
 * ZADANIE-1 (9p) : Wykreślanie na komponencie, animacje, wątki
 *
 * W programie Anim.java którego kod znajduje się poniżej
 *
 * // Animowanie figury // okrag odbija sie od krawedzi pulpitu. //
 * przygotowanie wpólrzednych figury w watku glownym, // wykreslanie w watku
 * zdarzeniowym w paintComponent().
 *
 * import java.util.*; import java.awt.*; import javax.swing.*;
 *
 * class BasicAnim extends JPanel {
 *
 * int dim = 20; //srednica figury int x = 75, y = 75; //polozenie poczatkowe
 * int dx = 3, dy = 5; //dlugosc kroku w kierunku x i y int delay = 40;
 * //opoznienie odswiezania
 *
 * public void paintComponent(Graphics g){ super.paintComponent(g);
 * g.setColor(Color.blue); //ustawienie koloru wykreslania g.fillOval(x, y, dim,
 * dim); //wypełnienie kola kolorem }
 *
 * public void startAnim(){ while(true){ // odbicie if(x + dim > getWidth() || x
 * < 0) dx = -dx; if(y + dim > getHeight() || y < 0) dy = -dy; // przesuniecie
 * wzdluz x i y x += dx; y += dy;
 *
 * repaint(); //wstawienie paintComponent() do watku zdarzeniowego
 *
 * try{Thread.sleep(delay);} //uspienie watku catch(InterruptedException e){ } }
 * }
 *
 * public Dimension getPreferredSize(){ return new Dimension(200, 200); }
 *
 * public static void main(String[] args){ JFrame frame = new
 * JFrame("Animacja"); //utworzenie okna ramowego BasicAnim anim = new
 * BasicAnim(); //utworzenie panelu do rysowania
 * frame.getContentPane().add(anim); //dodanie panelu do okna ramowego
 * frame.setLocation(300, 300); //lokalizacja okna na ekranie
 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //obsługa zamkniecia
 * okna frame.pack(); //upakowanie okna frame.show(); //wyswietlenie okna na
 * ekranie anim.startAnim(); // rozpoczecie animacji } }
 *
 * a) dokonaj zmian tak żeby przygotowanie współrzędnych figury do wykreslania
 * nie odbywało się w głównym wątku systemowym,lecz w wątku pobocznym,
 * utworzonym przez programistę. Dla ułatwienia komunikacji klasa wątku
 * pobocznego może być klasą wewnętrzną w klasie BasicAnim.
 *
 * b) wprowadź drugi wątek poboczny tak aby przemieszczanie się nowego koła
 * odbywało sie tak jak na rysunku(powrót po tej samej linii) dodaj do metody
 * paintComponent() wykreslanie nowego koła zgodnie z wątkiem drugim i wystartuj
 * oba watki.
 *
 * c) wprowadź następny wątek tak aby przemieszczanie się nowego koła odbywało
 * sie tak jak na rysunku(powrót po tej samej linii) dodaj do metody
 * paintComponent() wykreslanie nowego koła zgodnie z wątkiem trzecim i
 * wystartuj wszystkie 3 watki
 *
 * Zaobserwuj w czasie animacji wykonywanie zadań przez poszczególne wątki.
 *
 * @author s8376
 */
public class Zadanie05_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("Animacja");
		frame.setLocation(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CaseA caseA = new CaseA();
		frame.getContentPane().add(caseA);
		Thread caseAThread = new Thread(caseA);

		CaseB caseB = new CaseB();
		frame.getContentPane().add(caseB);
		Thread caseBThread = new Thread(caseB);

		CaseC caseC = new CaseC();
		frame.getContentPane().add(caseC);
		Thread caseCThread = new Thread(caseC);

		frame.pack();
		frame.setVisible(true);

		caseAThread.start(); // niebieski
		caseBThread.start(); // zielony
		caseCThread.start(); // czerwony
	}
}
