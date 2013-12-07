package gui.set01.zadanie03_2;

/**
 * Pracownik
 */
public class Pracownik extends Osoba {

	private String zawod;
	private double pensja;

	/**
	 *
	 */
	public Pracownik() {
		super();
		zawod = "dummy";
		pensja = 0.0;
	}

	/**
	 * @param imie
	 * @param nazwisko
	 * @param wiek
	 * @param zawod
	 * @param pensja
	 */
	public Pracownik(String imie, String nazwisko, int wiek, String zawod, double pensja) {
		super(imie, nazwisko, wiek);
		this.zawod = zawod;
		this.pensja = pensja;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return super.toString() + " " + getZawod() + " " + getPensja();
	}

	public String getZawod() {
		return zawod;
	}

	public double getPensja() {
		return pensja;
	}
}
