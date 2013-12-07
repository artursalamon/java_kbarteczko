package gui.set01.zadanie06_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Parser
 *
 * @author s8376
 */
public class Parser {

	HashMap<String, Integer> container = null;
	String file;

	/**
	 * @param file
	 */
	public Parser(String file) {
		this.file = file;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	HashMap<String, Integer> getData() throws Exception {

		if (container == null) {
			loadData(file);
		}

		return container;
	}

	/**
	 * @param file
	 */
	void loadData(String file) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line, letter;
			container = new HashMap<String, Integer>();

			while ((line = br.readLine()) != null) {
				for (int x = 0; x < line.length(); x++) {
					letter = line.substring(x, x + 1);
					if (!letter.equals(" ")) { // jesli nie jest spacja
						if (container.containsKey(letter)) {
							container.put(letter, container.get(letter) + 1);
						} else {
							container.put(letter, 1);
						}
					}
				}
			}

			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
