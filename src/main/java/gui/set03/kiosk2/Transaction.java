package gui.set03.kiosk2;

import java.util.EnumMap;

/**
 * Transaction
 *
 * Dosyć funkcjonalna enumeracja
 * opisuje możliwe transakcje (dostawa, sprzedaż gazet)
 * a zarazem prowadzi rejestr magazynu i rejestr sprzedanych gazet
 */
public enum Transaction {

	/**
	 * Elementy wyliczenia (konkretne operacje)
	 * Wiązemy z nimi ciała podklas, w których
	 * implementujemy metodę perform,
	 * która jest zadeklarowana na końcu jako abstrakcyjna
	 * Uwaga: w klasach enum elementy wyliczenia winny
	 * poprzedzać wszelkie rozszerzenia funkcjonalności
	 */
	SUPPLY {
		public void perform(Gazety g, int n) {
			if (volume.containsKey(g))
				n += volume.get(g);
			volume.put(g, n);
		}
	},

	SALE {
		public void perform(Gazety g, int n) {
			if (!volume.containsKey(g))
				return;
			int k = volume.get(g);
			if (n > k)
				n = k;
			volume.put(g, k - n);
			sold.put(g, n);
		}

	};

	/**
	 * @param g
	 * @return
	 */
	public static int getVolume(Gazety g) {
		if (!volume.containsKey(g))
			return 0;
		return volume.get(g);
	}

	/**
	 * @param g
	 * @return
	 */
	public static int getSold(Gazety g) {
		if (!sold.containsKey(g))
			return 0;
		return sold.get(g);
	}

	/**
	 * Gazety - stan magazynowy
	 */
	private static final EnumMap<Gazety, Integer> volume = new EnumMap<Gazety, Integer>(
			Gazety.class);
	/**
	 * Gazety - sprzedane
	 */
	private static final EnumMap<Gazety, Integer> sold = new EnumMap<Gazety, Integer>(
			Gazety.class);

	/**
	 * Metoda perform musi być zsdeklarowana jako abstrakcyjna
	 * ona własnie jest w różny sposób implemetowana w ciałach podklas
	 * przypisanych stałym wyliczenia
	 *
	 * @param g
	 * @param n
	 */
	public abstract void perform(Gazety g, int n);
}
