package gui.set03.vehicle;

/**
 * Vehicle
 */
public class Vehicle {

	public final static int BROKEN = 0, STOPPED = 1, MOVING = 2; // stany
	private final static String[] states = {"ZEPSUTY", "STOI", "JEDZIE"}; // nazwy stanów

	private static int count; // liczba dotąd utworzonych obiektów,
	// inicjalnie 0

	private int currNr = ++count; // przy tworzeniu obiektu count zwiększa się o 1
	// i staje się numerem pojazdu

	private int width, height, length, weight; // atrybuty pojazdu
	private Person owner; // ... właściciel
	private int state = STOPPED; // ... stan

	/**
	 *
	 */
	public Vehicle() {
	} // konstruktor bezparametrowy

	// konstruktor; tworzy pojazdy bez właściciela
	public Vehicle(int w, int h, int l, int ww) {
		this(null, w, h, l, ww);
	}

	// pełny konstruktor
	public Vehicle(Person p, int w, int h, int l, int ww) {
		owner = p;
		width = w;
		height = h;
		length = l;
		weight = ww;
	}

	public void start() { // start pojazdu
		setState(MOVING);
	}

	public void stop() { // zatrzymanie pojazdu
		setState(STOPPED);
	}

	// Robocza metoda zmiany stanu, wykorzystywana w stop() i start()
	// Uwzględnia możliwe zmiany stanów (sprawdza to)
	// Jest prywatna: arbitralna zmiana stanu pojazdu
	//nie jest możliwa spoza klasy
	private void setState(int newState) {
		if (state == newState || state == BROKEN)
			System.out.println("Nie jest mozliwe przejscie ze stanu "
					+ states[state] + " do stanu " + states[newState]);
		else
			state = newState;
	}

	// Reperowanie pojazdu:
	// zawsze zakończone sukcesem, jeśli tylko można przystąpić do naprawy :-)
	public Vehicle repair() {
		if (state == MOVING)
			System.out.println("Nie można reperować jadącego pojazdu");
		else if (state != BROKEN)
			System.out.println("Pojazd sprawny");
		else
			state = STOPPED;
		return this;
	}

	// zwraca stan jako liczbę;
	// można ją porównać ze stałymi Vehicle.BROKEN, Vehicle.STOPPED  itp.
	public int getState() {
		return state;
	}

	// Zwraca nazwę stanu podanego jako argument
	public static String getState(int state) {
		return states[state];
	}

	// czy pojazd stoi?
	public boolean isStopped() {
		return state == STOPPED;
	}

	// Kolizja: w wyniku kolizji oba pojazdy w niej uczestniczące
	//stają się niesprawne
	// Nie może być kolizji, jeśli oba pojazdy stoją
	public void crash(Vehicle v) {
		if (state != MOVING && v.state != MOVING)
			System.out.println("Nie ma kolizji");
		else {
			setState(BROKEN);
			v.setState(BROKEN);
		}
	}

	public void sellTo(Person p) { // sprzedaż pojazdu osobie p
		owner = p;
	}

	public int getNr() {
		return currNr;
	} // zwraca unikalny numer pojazdu

	// Czy pojazd może przejechać pod konstrukcją o podanej wysokości?
	public boolean isTooHighToGoUnder(int limit) {
		return height > limit ? true : false;
	}

	// Metoda toString uwzględnia teraz,
	// że pojazd może jeszcze nie mieć właściciela
	public String toString() {
		String s = (owner == null ? "sklep" : owner.getName());
		return "Pojazd " + currNr + " ,właścicielem którego jest " + s + " - "
				+ states[state];
	}

	// ile pojazdów utworzyliśmy dotąd?
	static int getCount() {
		return count;
	}

	// zwraca tablicę nazw dostępnych stanów pojazdu
	static String[] getAvailableStates() {
		return states;
	}

}

class VehTest { // klasa testująca

	// Metoda raportująca stan tablicy pojazdów
	// przekazanych jako argument
	static void report(String msg, Vehicle[] v) {
		System.out.println(msg);
		for (int i = 0; i < v.length; i++)
			System.out.println("" + v[i]);
	}

	public static void main(String[] args) {
		System.out.println("Dopuszczalne stany pojazdow");
		String[] states = Vehicle.getAvailableStates();
		for (int i = 0; i < states.length; i++)
			System.out.println(states[i]);

		System.out.println("W programie mamy teraz pojazdow: "
				+ Vehicle.getCount());

		Vehicle[] v = {
				new Vehicle(new Person("Jan Piesio", "010268246"), 200, 150,
						500, 900),
				new Vehicle(new Person("Stefan Kot", "010262241"), 210, 250,
						800, 1900), new Vehicle(200, 230, 300, 600),};

		System.out.println("W programie mamy teraz pojazdow: "
				+ Vehicle.getCount());
		report("Na początku", v);
		System.out.println("Pojazd 3 zostaje sprzedany Ambrożemu");
		v[2].sellTo(new Person("Ambroży", "000000"));
		for (int i = 0; i < v.length; i++)
			v[i].start();

		report("Po wyruszeniu", v);
		// Czy mogą przejechać pod wiaduktem 220 cm?
		for (int i = 0; i < v.length; i++)
			if (v[i].isTooHighToGoUnder(220))
				v[i].stop();

		report("Komu udało się przejechać pod wiaduktem ?", v);

		// Zatrzymane wyruszaja w objazd
		for (int i = 0; i < v.length; i++)
			if (v[i].isStopped())
				v[i].start();
		report("Po wyruszeniu w objazd", v);

		// Kolizja
		v[0].crash(v[1]);
		report("Po kolizji", v);
		System.out.println("Piesio próbuje ruszyć");
		v[0].start();
		System.out
				.println("Piesio sprzedaje pojazd Krówce. Ta go reperuje i jedzie");
		v[0].sellTo(new Person("Anna Krówka", "121212908"));
		v[0].repair().start();
		report("Ostatecznie", v);

		System.out.println("Stan pojazdu 3 "
				+ Vehicle.getState(v[2].getState()));
	}

}
