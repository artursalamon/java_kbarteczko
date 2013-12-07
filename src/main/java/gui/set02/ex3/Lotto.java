package gui.set02.ex3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Lotto
 */
public class Lotto {

	private int numbers = 6;

	/**
	 *
	 */
	public Lotto() {

		try {
			int[] usersNumbers = input();


		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private int[] input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[this.numbers];
		int counter = 0;
		int userNumber;

		while (counter < 6) {
			try {
				System.out.println("Podaj liczbę " + (counter + 1));
				userNumber = Integer.parseInt(br.readLine());
				if (userNumber <= 0 || userNumber > 49) {
					throw new Exception("Niepoprawna liczba");
				}
				numbers[counter] = userNumber;
				counter++;
			} catch (Exception e) {
				System.out.println("Niepoprawna liczba");
			}
		}

		br.close();
		return numbers;
	}

	private void random() {

	}

	private void compare() {

	}
}
