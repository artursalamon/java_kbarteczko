package gui.set03.kiosk2;

/**
 * Gazety
 */
public enum Gazety {

	/**
	 * W konstruktorze użyjemy dwóch parametrów
	 * Ze stałymi wyliczenia zwiążemy przedefiniowane metody toString
	 * tak, by wydruk był ładniejszy nieco
	 */
	Glos(0.75, 1) {
		public String toString() {
			return "Tygodnik \\\"Głos\\\"";
		}
	},

	Polityka(4, 4.5) {
		public String toString() {
			return "Tygodnik \\\"Polityka\\\"";
		}
	},

	Gazeta(2, 2.5) {
		public String toString() {
			return "\\\"Gazeta Wyborcza\\\"";
		}
	};

	Gazety(double wp, double rp) {
		wholesalePrice = wp;
		retailPrice = rp;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	private final double wholesalePrice;
	private final double retailPrice;
}
