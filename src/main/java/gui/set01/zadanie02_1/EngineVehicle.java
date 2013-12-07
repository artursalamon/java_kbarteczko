package gui.set01.zadanie02_1;

/**
 * EngineVehicle
 */
public class EngineVehicle extends Vehicle {

	protected int fuelTankCapability; // pojemnosc zbiornika
	protected int fuelTankQuantity; // stan paliwa
	protected String registerNumber; // numer rejestracyjny,

	/**
	 * @param rn
	 * @param p
	 * @param w
	 * @param h
	 * @param l
	 * @param ww
	 * @param fc
	 */
	public EngineVehicle(String rn, Person p, int w, int h, int l, int ww, int fc) {

		registerNumber = rn;
		owner = p;
		width = w;
		height = h;
		length = l;
		weight = ww;
		fuelTankCapability = fc;
	}

	/**
	 * @param quantity
	 */
	public void fill(int quantity) {

		if (quantity < 0) {
			return;
		}
		if ((fuelTankQuantity + quantity) > fuelTankCapability) {
			return;
			//			throw new Exception("Ilość paliwa przekracza pojemność zbiornika");
		}
		fuelTankQuantity += quantity;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
}
