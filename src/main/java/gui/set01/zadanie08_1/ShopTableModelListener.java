package gui.set01.zadanie08_1;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * ShopTableModelListener
 *
 * @author s8376
 */
public class ShopTableModelListener implements TableModelListener {

	/**
	 * @param e
	 */
	public void tableChanged(TableModelEvent e) {

		ShopTableModel model = (ShopTableModel) e.getSource();

		int row = e.getFirstRow();
		int column = e.getColumn();

		System.out.println(e.getType());


		System.out.println(model.getColumnName(column));
		System.out.println(model.getValueAt(row, column));


		System.out.println(model.getValueAt(row, column));
	}
}
