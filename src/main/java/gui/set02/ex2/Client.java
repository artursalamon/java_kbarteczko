package gui.set02.ex2;

/**
 * Client
 */
public class Client {

	/**
	 * Kod PIN, pelniacy role ID
	 */
	private Integer pin;
	/**
	 * Saldo konta
	 */
	private Integer balance;
	/**
	 * Limit wyplat
	 */
	private Integer limit;
	/**
	 * Limit wyplat zuzyty
	 */
	private Integer limitUsed;
	/**
	 * Timestamp dnia, dla jakiego jest limit
	 */
	private Long timestamp;

	/**
	 * @param pin
	 * @param balance
	 * @param limit
	 * @param limitUsed
	 * @param timestamp
	 */
	Client(Integer pin, Integer balance, Integer limit, Integer limitUsed, Long timestamp) {

		this.pin = pin;
		this.balance = balance;
		this.limit = limit;
		this.limitUsed = limitUsed;
		this.timestamp = timestamp;
	}

	/**
	 * @param pin
	 * @return
	 */
	public boolean authByPIN(Integer pin) {
		return this.pin.equals(pin) ? true : false;
	}

	/**
	 * @return
	 */
	public String prepareToModel() {
		String separator = ";";
		return pin + separator + balance + separator + limit + separator + limitUsed + separator + timestamp;
	}

	public Integer getBalance() {
		return balance;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getPin() {
		return pin;
	}

	public Integer getLimitUsed() {
		return limitUsed;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setLimitUsed(Integer limitUsed) {
		this.limitUsed = limitUsed;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
