package gui.set03.table;

import javax.swing.table.AbstractTableModel;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * KalTableModel
 */
public class KalTableModel extends AbstractTableModel {

	static String[] columnNames = {"Dzień", "Pogoda", "Temperatura",
			"Czy był udany?"};
	final static Calendar kalend = new GregorianCalendar();
	final static String[] nazwaDnia = {"niedziela", "poniedziałek", "wtorek",
			"środa", "czwartek", "piątek", "sobota"};
	final static String[] nazwaMies = {"stycznia", "lutego", "marca",
			"kwietnia", "maja", "czerwca", "lipca", "sierpnia", "września",
			"października", "listopada", "grudnia"};
	final static String[] typPogody = {"Nieznana", "Słońce", "Chmury",
			"Deszcz", "Śnieg"};
	public final static int minTemp[] = {-50, -50, -40, -20, -10, 0, 0, 0,
			-10, -20, -40, -40};
	public final static int maxTemp[] = {15, 15, 25, 30, 40, 40, 50, 50, 50,
			40, 30, 20, 20};
	int mies; // miesiąc
	Integer[] temper = new Integer[31]; // temperatura
	String[] pogoda = new String[31]; // opis pogody
	Boolean[] udany = new Boolean[31]; // czy dzień udany?

	/**
	 * @param mies
	 */
	KalTableModel(int mies) { // numer miesiąca

		this.mies = mies - 1;
		kalend.set(2000, mies, 1); // ustawienie kalendarza
		for (int i = 0; i < 31; i++) { // inicjalizacja innych pól
			temper[i] = new Integer(minTemp[mies - 1]);
			udany[i] = new Boolean(false);
			pogoda[i] = "Nieznana";
		}
	}

	@Override
	public Class getColumnClass(int c) {
		// klasa danych w pierwszej komórce kolumny c
		return getValueAt(0, c).getClass();
	}

	@Override
	public int getColumnCount() {

		return 0;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {

		return 0;
	}

	public String[] getTypPogody() {
		return typPogody;
	}

	@Override
	public Object getValueAt(int i, int j) {
		Object o = null;
		kalend.set(Calendar.DAY_OF_MONTH, i + 1);
		int indDnia = kalend.get(Calendar.DAY_OF_WEEK) - 1;
		switch (j) {
			case 0:
				o = (i + 1) + "  " + nazwaMies[mies] + " " + nazwaDnia[indDnia];
				break;
			case 1:
				o = pogoda[i];
				break;
			case 2:
				o = temper[i];
				break;
			case 3:
				o = udany[i];
				break;
			default:
				break;
		}
		return o;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		if (col == 0) { // komórki kolumny "Dzień" nie są edytowalne!
			return false;
		} else {
			return true;
		}
	}

	public void setValueAt(Object value, int i, int j) {
		switch (j) {
			case 1:
				pogoda[i] = (String) value;
				break;
			case 2:
				temper[i] = (Integer) value;
				break;
			case 3:
				udany[i] = (Boolean) value;
				break;
			default:
				break;
		}
		// zmiana modelu: należy powiadomić wszystkich TableModelListener-ów
		fireTableCellUpdated(i, j); // komórka zmodyfikowana
	}
}
