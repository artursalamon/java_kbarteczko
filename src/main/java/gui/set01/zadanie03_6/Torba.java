package gui.set01.zadanie03_6;

/**
 * Torba
 */
public class Torba extends ContainerAbstract {

	protected String owner;

	/**
	 * @param owner
	 */
	public Torba(String owner) {
		super();
		this.owner = owner;
	}

	/**
	 * @param koszyk
	 * @return
	 */
	public Torba loadFrom(Koszyk koszyk) {

		for (Product val : koszyk.getStorage()) {
			storage.add(val);
		}

		return this;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "torba [ właściciel: " + owner + " ]";
	}
}
