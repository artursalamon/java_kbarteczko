package gui.set01.zadanie08_1;

import javax.swing.table.AbstractTableModel;

/**
 * ShopTableModel
 *
 * @author s8376
 */
public class ShopTableModel extends AbstractTableModel {

	public final static int ID_IDX = 0;
	public final static int NAME_IDX = 1;
	public final static int PRODUCER_IDX = 2;
	public final static int PRICE_IDX = 3;

	public final static String ID_NAME = "Numer porządkowy";
	public final static String NAME_NAME = "Nazwa towaru";
	public final static String PRODUCER_NAME = "Producent";
	public final static String PRICE_NAME = "Cena";

	private final static String[] columnNames = {ID_NAME, NAME_NAME,
			PRODUCER_NAME, PRICE_NAME};
	private Object[][] products = {{null, "Proszek do prania", "Ajax", 4.5},
			{null, "Kawa mielona", "Java", 8.0},
			{null, "Pasta do butów", "Polish", 3.2},
			{null, "Spinacz biurowy", "Biurex", 0.01},
			{null, "Ołówek", "Biurex", 0.3},
			{null, "Grzebień", "Badzieweks", 1.0},
			{null, "Szczoteczka do zębów", "Badzieweks", 2.85},
			{null, "Pani domu", "Wydawnictwo ABC", 5.3},
			{null, "Gotowanie", "Wydawnictwo ABC", 4.75},
			{null, "Horoskopy", "Wydawnictwo ABC", 3.99}};

	/**
	 *
	 */
	public ShopTableModel() {
		addTableModelListener(new ShopTableModelListener());
	}

	/**
	 * @return
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * @param column
	 * @return
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column].toString();
	}

	/**
	 * @return
	 */
	@Override
	public int getRowCount() {

		if (products == null) {
			return 0;
		}
		return products.length;
	}

	/**
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return columnIndex == ID_IDX ? rowIndex + 1
				: products[rowIndex][columnIndex];
	}

	/**
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == PRICE_IDX ? true : false;
	}
}
