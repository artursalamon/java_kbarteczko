package gui.set01.zadanie08_2;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * BookPriceRenederer
 *
 * @author s8376
 */
public class BookPriceRenederer extends JLabel implements TableCellRenderer {

	boolean isBordered;

	/**
	 * @param isBordered
	 */
	public BookPriceRenederer(boolean isBordered) {
		this.isBordered = isBordered;
		setOpaque(true);
	}

	/**
	 * @param table
	 * @param color
	 * @param isSelected
	 * @param hasFocus
	 * @param row
	 * @param column
	 * @return
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object color,
	                                               boolean isSelected, boolean hasFocus, int row, int column) {

		setForeground(Color.RED);
		setBackground(Color.YELLOW);

		return this;
	}
}
