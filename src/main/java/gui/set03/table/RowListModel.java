package gui.set03.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RowListModel
 *
 * @param <E>
 */
public abstract class RowListModel<E> extends AbstractTableModel {

	private List<String> colNames;
	private List<E> rows;

	/**
	 * @param elist
	 * @param cols
	 */
	public RowListModel(List<E> elist, String[] cols) {
		rows = new ArrayList<E>(elist);
		colNames = Arrays.asList(cols);
	}

	@Override
	public int getColumnCount() {
		return colNames.size();
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public String getColumnName(int column) {
		return colNames.get(column);
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/**
	 * @param r
	 * @return
	 */
	public E getRow(int r) {
		return rows.get(r);
	}

	/**
	 * @param newVal
	 */
	public void addRow(E newVal) {
		rows.add(newVal);
		this.fireTableDataChanged();
	}
}
