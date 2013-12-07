package gui.set03.table;

import java.util.Date;
import java.util.List;

/**
 * EmpTabModel
 */
public class EmpTabModel extends RowListModel<Employee> {

	/**
	 * @param elist
	 * @param cols
	 */
	public EmpTabModel(List<Employee> elist, String[] cols) {
		super(elist, cols);
	}

	/**
	 * @param r
	 * @param c
	 * @return
	 */
	@Override
	public Object getValueAt(int r, int c) {

		Employee e = getRow(r);
		switch (c) {
			case 0:
				return e.getName();
			case 1:
				return e.getAddress();
			case 2:
				return e.getBirthDate();
			case 3:
				return e.getSalary();
			default:
				return null;
		}
	}

	/**
	 * @param val
	 * @param r
	 * @param c
	 */
	@Override
	public void setValueAt(Object val, int r, int c) {

		Employee emp = getRow(r);
		switch (c) {
			case 0:
				emp.setName((String) val);
				break;
			case 1:
				emp.setAddress((Address) val);
				break;
			case 2:
				emp.setBirthDate((Date) val);
				break;
			case 3:
				emp.setSalary((Integer) val);
				break;
			default:
				break;
		}
		this.fireTableCellUpdated(r, c);
	}
}
