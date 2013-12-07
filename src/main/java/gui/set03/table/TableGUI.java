package gui.set03.table;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class TableGUI<M extends RowListModel<E>, E> extends JFrame implements
		ActionListener {

	private static ImageIcon specFiltersImg = new ImageIcon(TableGUI.class.getResource("resources/help.gif"));

	// Model danych
	private M model;
	// Tabela
	private JTable table;
	// Sorter
	private TableRowSorter<M> sorter;
//	private FilterDialog<M> filterDialog;
//	private SortPanel sortPanel;

	public TableGUI(String title, final M model) {
		super(title);
		this.model = model;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// Utworzenie sortera
		sorter = new TableRowSorter<M>(model);

		// Tabela i ustalenie sortera
		table = new JTable(model);
		table.setRowSorter(sorter);

		// Szybkie wyrównanie dat (jesli są) do prawej (bez własnego renderera)
		TableCellRenderer cellRenderer = table.getDefaultRenderer(Date.class);
		((JLabel) cellRenderer).setHorizontalAlignment(JLabel.RIGHT);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isAltDown()) {
					int r = table.rowAtPoint(e.getPoint());
					r = table.convertRowIndexToModel(r);
//					SimpleDialog.show(TableGUI.this, "Edycja", model, r);
				} else if (e.isMetaDown()) {
					JPopupMenu pm = getPopupSortKeysWindow();
					pm.show(e.getComponent(), e.getX(), e.getY());
				}
			}

		});

		add(new JScrollPane(table));

		Box controls = Box.createHorizontalBox();
		controls.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));
//		Dimension filler = new Dimension(5, 5);
//		controls.add(button("Sort ...", "cmd:sort", this));
//		controls.add(Box.createRigidArea(filler));
//		controls.add(button("Filter ...", "cmd:filter", this));
//		controls.add(Box.createGlue());
//		controls.add(button("Add record ...", "cmd:add", this));
//		controls.add(Box.createRigidArea(filler));
//		controls.add(check("Update on insert ?", "cmd:updateable", this));
//		controls.add(Box.createGlue());
//		controls.add(label(specFiltersImg, "hint:Special filters",
//				showSpecialsPopupMenu));
		add(controls, "South");
	}

	public M getModel() {
		return model;
	}

	public TableRowSorter<M> getSorter() {
		return sorter;
	}

	public JTable getTable() {
		return table;
	}

	private JPopupMenu getPopupSortKeysWindow() { // panel sortowania dostępny jako popup
		final JPopupMenu popup = new JPopupMenu();
//		if (sortPanel == null)
//			sortPanel = new SortPanel(table);
//		sortPanel.setCloseButton(true);
//		popup.add(sortPanel);
		return popup;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		M model = ((M) table.getModel());

		if (cmd.equals("add")) {
			// obsługa dodoawnia nowego rekordu

		} else if (cmd.equals("filter")) { // dialog filtrowania
//			if (filterDialog == null)
//				filterDialog = new FilterDialog<M>(TableGUI.this,
//						"Filtrowanie", model);
//			RowFilter<? super M, ? super Integer> filtr = filterDialog
//					.getFilter();
//			sorter.setRowFilter(filtr);

		} else if (cmd.equals("sort")) { // dialog sortowania
			JDialog sortDialog = new JDialog(TableGUI.this, "Sortowanie", true);
//			if (sortPanel == null)
//				sortPanel = new SortPanel(table);
//			sortPanel.setCloseButton(false);
//			sortDialog.add(sortPanel);
			sortDialog.pack();
			sortDialog.setLocationRelativeTo(TableGUI.this);
			sortDialog.setVisible(true);

		} else if (cmd.equals("updateable")) {
			JToggleButton tb = (JToggleButton) e.getSource();
			sorter.setSortsOnUpdates(tb.isSelected());
		}

	}

	// Menu dla specjalnych akcji, które można okreslić z zewnątrz
	private JPopupMenu specialsPopupMenu;

	MouseListener showSpecialsPopupMenu = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if (specialsPopupMenu == null)
				return;
			Dimension d = specialsPopupMenu.getPreferredSize();
			specialsPopupMenu.show(e.getComponent(), e.getX() - d.width, e
					.getY()
					- d.height);
		}
	};

	public void setSpecialsPopupMenu(Action[] specialActions) {
		specialsPopupMenu = new JPopupMenu();
		for (Action action : specialActions) {
			specialsPopupMenu.add(action);
		}
	}
}
