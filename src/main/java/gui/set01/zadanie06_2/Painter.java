package gui.set01.zadanie06_2;

import javax.swing.*;
import java.awt.*;
import java.text.Collator;
import java.util.*;
import java.util.List;

/**
 * Painter
 *
 * @author s8376
 */
public class Painter extends JPanel {

	Parser parser;
	int counterMin = 0, counterMax = 0;
	List<Object> keysList;
	HashMap<String, Integer> container;
	Panel[] panels;

	/**
	 * @param parser
	 */
	public Painter(Parser parser) {

		this.parser = parser;
		boolean first = true;

		try {
			container = this.parser.getData();
			keysList = Arrays.asList(container.keySet().toArray());
			Collections.sort(keysList, Collator
					.getInstance(Locale.getDefault()));

			Panel panel;
			int x = 0;
			panels = new Panel[keysList.size()];

			// obliczam wartosci najmniejsze i najwieksze
			for (Object key : keysList.toArray()) {
				if (first) {
					counterMin = container.get(key);
					counterMax = container.get(key);
					first = false;
				}
				if ((int) container.get(key) < counterMin) {
					counterMin = (int) container.get(key);
				}
				if ((int) container.get(key) > counterMax) {
					counterMax = (int) container.get(key);
				}


				panel = new Panel();
				panel.setLineWidth((100 * ((int) container.get(key)))
						/ counterMax);

				panel.setTitle("" + key);
				panel.setCounter(container.get(key));

				if ((int) container.get(key) == counterMin) {
					panel.setColor(Color.gray);
				} else if ((int) container.get(key) == counterMax) {
					panel.setColor(Color.red);
				}

				add(panel);
				panels[x] = panel;
				x++;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
