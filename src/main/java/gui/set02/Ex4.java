package gui.set02;

import gui.set02.ex4.TicTacToe;

/**
 * Ex4
 *
 * Napisać progam symulujący popularną grę planszową "kółko i krzyżyk"
 * (w trybie tekstowym).
 * Jeden z graczy to użytkownik uruchamiający program a drugi to komputer.
 * Pola planszy w programie to komórki tablicy dwuwymiarowej o odpowiednim
 * wymiarze.Po każdym zagraniu program prezentuje aktualne wypełnienie planszy
 * oraz wynik gry. Program musi być napisany w sposób skalowalny - gra może
 * odbywać się na planszy 3x3, 4x4, 5x5 itd. Trafienia każdego z graczy liczymy
 * wzdłuż wierszy, kolumn i przekątnych planszy a ilość trafień podajemy jako
 * parametr gry.
 *
 * @todo
 */
public class Ex4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TicTacToe();
	}
}
