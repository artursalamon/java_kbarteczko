package gui.set01.zadanie08_2;

import javax.swing.table.AbstractTableModel;

/**
 * BookstoreTableModel
 *
 * @author s8376
 */
public class BookstoreTableModel extends AbstractTableModel {

	public final static int ID_IDX = 0;
	public final static int AUTHOR_IDX = 1;
	public final static int TITLE_IDX = 2;
	public final static int PUBLISHINGHOUSE_IDX = 3;
	public final static int PRICE_IDX = 4;
	public final static int FRONTPAGE_IDX = 5;

	public final static String ID_NAME = "ID";
	public final static String AUTHOR_NAME = "Autor";
	public final static String TITLE_NAME = "Tytuł";
	public final static String PUBLISHINGHOUSE_NAME = "Wydawnictwo";
	public final static String PRICE_NAME = "Cena";
	public final static String FRONTPAGE_NAME = "Strona tytułowa";

	private final static String[] columnNames = {ID_NAME, AUTHOR_NAME,
			TITLE_NAME, PUBLISHINGHOUSE_NAME, PRICE_NAME, FRONTPAGE_NAME};
	private Object[] products;

	/**
	 * @param pathToStorageFile
	 */
	public BookstoreTableModel(String pathToStorageFile) {

		try {
			addTableModelListener(new BookstoreTableModelListener());

			BookstoreModel model = new BookstoreModel(pathToStorageFile);
			products = model.getData();
		} catch (Exception e) {
			System.err.println(e.toString());
			System.exit(1);
		}
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
		return columnNames[column];
	}

	/**
	 * @return
	 */
	@Override
	public int getRowCount() {
		return products.length;
	}

	/**
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (products == null)
			return null;

		Book book = (Book) products[rowIndex];

		switch (columnIndex) {
			case ID_IDX:
				return book.getId();
			case AUTHOR_IDX:
				return book.getAuthorName();
			case FRONTPAGE_IDX:
				return book.getFrontpageImage();
			case PRICE_IDX:
				return book.getPrice();
			case PUBLISHINGHOUSE_IDX:
				return book.getPublishingHouse();
			case TITLE_IDX:
				return book.getTitle();
		}

		return null;
	}

	/**
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
}
