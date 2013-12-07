package gui.set01.zadanie03_2;

/**
 * Osoba
 */
public class Osoba {

	private String imie;
	private String nazwisko;
	private int wiek;

	/**
	 *
	 */
	public Osoba() {
		this("dummy", "dummy", 0);
	}

	/**
	 * @param imie
	 * @param nazwisko
	 * @param wiek
	 */
	public Osoba(String imie, String nazwisko, int wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
	}

	/**
	 *
	 */
	public void show() {
		System.out.println(toString());
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return getImie() + " " + getNazwisko() + " " + getWiek();
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public int getWiek() {
		return wiek;
	}
}
