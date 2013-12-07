package gui.set02.ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

/**
 * ATM
 */
public class ATM {

	public final static int ACTION_BREAK = -1;
	public final static int ACTION_MAIN_MENU = 1;
	public final static int ACTION_SHOW_BALANCE = 2;
	public final static int ACTION_PAYMENT = 3;

	private Integer failedAuthLimit = 3;
	private GUI gui;
	private DataHandler dataHandler;
	private Client client;

	/**
	 * @param path
	 */
	public ATM(String path) {

		gui = new GUI();

		try {
			dataHandler = new DataHandler(path);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			Integer action = 0;
			Integer failedAuth = 0;
			Integer amount;
			boolean escape = false;

			Calendar calendar = Calendar.getInstance();
			Date dateNow;

			while (true) {
				switch (action) {
					case ATM.ACTION_BREAK:
						escape = true;
						break;
					case ATM.ACTION_SHOW_BALANCE:
						gui.showAlert("Stan Twojego konta to: " + client.getBalance() + "PLN");
						action = ATM.ACTION_MAIN_MENU;
						break;
					case ATM.ACTION_PAYMENT:
						gui.showAlert("Wpisz kwotę (lub 0 aby wrócić do menu):");

						try {
							amount = Integer.parseInt(br.readLine());

							if (amount == 0) {
								action = ATM.ACTION_MAIN_MENU;
								break;
							}
							if (amount < 0) {
								throw new Exception("Niepoprawna kwota");
							}
							if (amount % 100 != 0) {
								throw new Exception("Kwota musi być wielokrotnością 100PLN");
							}

							if (client.getBalance() - amount < 0) {
								gui.showAlert("Brak wystarczających środków na koncie");
								break;
							}

							// ustalenie timestamp
							calendar.setTime(new Date());

							calendar.set(Calendar.AM_PM, 0);
							calendar.set(Calendar.HOUR, 0);
							calendar.set(Calendar.MINUTE, 0);
							calendar.set(Calendar.SECOND, 0);

							dateNow = calendar.getTime();

							// reset daty
							if (client.getTimestamp() != dateNow.getTime()) {
								client.setLimitUsed(0);
								client.setTimestamp(dateNow.getTime());
							}

							// test na limit wyplad na dzien
							if (client.getLimitUsed() + amount > client.getLimit()) {
								gui.showAlert("Przekroczony limit na wypłatę na dobę");
								gui.showAlert("Do wypłaty pozostało " + (client.getLimit() - client.getLimitUsed()) + "PLN na dzień " + dateNow);
								break;
							}

							// wyplata
							client.setBalance(client.getBalance() - amount);
							client.setLimitUsed(client.getLimitUsed() + amount);
							dataHandler.writeFile();
							action = ATM.ACTION_MAIN_MENU;
						} catch (Exception e) {
							gui.showAlert(e.getMessage());
						}
						break;
					case ATM.ACTION_MAIN_MENU:
						gui.showMenu();

						try {
							switch (Integer.parseInt(br.readLine())) {
								case 1:
									action = ATM.ACTION_SHOW_BALANCE;
									break;
								case 2:
									action = ATM.ACTION_PAYMENT;
									break;
								case 3:
									action = ATM.ACTION_BREAK;
									break;
								default:
							}
						} catch (Exception e) {
							// wadliwe parametry wejsciowe wyboru opcji menu
						}
						break;
					default:
						if (failedAuth >= failedAuthLimit) {
							throw new Exception("Przekroczono limit nieudanych prób autoryzacji");
						}
						gui.showAuth();
						try {
							client = dataHandler.getAccount(Integer.parseInt(br.readLine()));
							action = ATM.ACTION_MAIN_MENU;
						} catch (Exception e) {
							gui.showAlert("Niepoprawna autoryzacja (niepoprawny numer PIN)");
							failedAuth++;
						}
				}

				if (escape) {
					gui.showAlert("Bye!");
					break;
				}
			}
		} catch (Exception e) {
			gui.showAlert(e.getMessage());
		}
	}
}
