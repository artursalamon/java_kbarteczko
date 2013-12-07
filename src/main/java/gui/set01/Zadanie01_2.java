package gui.set01;

import gui.set01.zadanie01_2.Model;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Zadanie 2 - działanie bankomatu
 *
 * Napisać program symulujący pobieranie pieniędzy z bankomatu  a w szczególności:
 *
 * * wprowadzanie pinkodu
 * * sprawdanie czy dany pinkod znajduje się na predefiniowanej liście
 * uprawnionych pinkodów
 * * blokada bankomatu po 3 nieudanych próbach zalogowania
 * * wypłacanie tylko wielokrotności 100 PL
 * * limit dzienny wypłaty
 *
 * Jako prostej bazy danych można użyć  plików.
 *
 * @author s8376
 */
public class Zadanie01_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean inputFlag;
		boolean pinOk = false;
		int pinCounter = 3;
		String input, titleMessage, faceValue = "PLN";
		Model model = new Model("Files/Zadanie2Storage.txt");
		Hashtable<String, String> account;

		String cardNum = "555123112312313"; // symulacja wlozonej karty

		while (true) {
			try {
				account = model.getAccount(cardNum);

				if (pinOk == false) {
					inputFlag = false;
					titleMessage = "";
					while (inputFlag == false) {
						try {
							input = JOptionPane.showInputDialog((titleMessage
									.length() > 0 ? titleMessage + "\n" : "")
									+ "Podaj numer PIN");
							if (account.get("pin").equals(input)) {
								inputFlag = true;
								pinOk = true;
							} else {
								throw new Exception("Niepoprawny numer PIN");
							}
						} catch (Exception e) {
							pinCounter--;
							if (pinCounter <= 0) {
								throw new Exception(
										"Przekroczono limit prób podania numeru PIN");
							}
							titleMessage = "Błędny PIN, pozostało prób:"
									+ pinCounter;
							inputFlag = false;
						}
					}
				}

				Date dateNow, dateModel;
				double inputDouble;
				String dateFormat = "yyyyMMddHHmm";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						dateFormat);

				inputFlag = false;
				titleMessage = "";

				while (inputFlag == false) {
					try {
						// RESET LICZNIKA
						dateNow = new Date();
						dateModel = simpleDateFormat.parse(account
								.get("timeLastUsage"));

						if (simpleDateFormat.format(dateNow).toString()
								.substring(0, 8).equals(
										simpleDateFormat.format(dateModel)
												.toString().substring(0, 8))) {
							// do nothing
						} else {
							account.put("counterDay", "0");
						}

						input = JOptionPane.showInputDialog((titleMessage
								.length() > 0 ? titleMessage + "\n" : "")
								+ "Podaj kwotę do pobrania");

						if (input == null) {
							break;
						}

						try {
							inputDouble = Double.parseDouble(input);
						} catch (NumberFormatException e) {
							throw new Exception("Nieprawidłowy format kwoty");
						}

						if (inputDouble % 100 != 0) {
							throw new Exception(
									"Bankomat wypłaca jedynie banknoty o nominale 100"
											+ faceValue);
						}

						if (inputDouble > Double.parseDouble(account
								.get("balance"))) {
							throw new Exception(
									"Podana kwota przewyższa dostępny stan konta: "
											+ account.get("balance")
											+ faceValue);
						}

						if (inputDouble > Double.parseDouble(account
								.get("limitPerOnce"))) {
							throw new Exception(
									"Podana kwota przewyższa jednorazowy limit wypłaty: "
											+ account.get("limitPerOnce")
											+ faceValue);
						}

						if (inputDouble > Double.parseDouble(account
								.get("limitPerDay"))
								- Double.parseDouble(account.get("counterDay"))) {
							throw new Exception(
									"Przekroczono dzienny limit wypłaty: "
											+ account.get("limitPerDay")
											+ faceValue);
						}

						inputFlag = true;

						account
								.put("balance", ""
										+ (Double.parseDouble(account
										.get("balance")) - inputDouble));
						account
								.put(
										"counterDay",
										""
												+ (Double.parseDouble(account
												.get("counterDay")) + inputDouble));

						StringBuilder dateStringNow = new StringBuilder(
								simpleDateFormat.format(dateNow));
						account.put("timeLastUsage", dateStringNow.toString());

						model.setAccount();

						JOptionPane.showMessageDialog(null, "Wypłacono kwotę: "
								+ inputDouble + faceValue);
					} catch (Exception e) {
						titleMessage = e.getMessage();
						inputFlag = false;
					}
				}

				if (JOptionPane.showConfirmDialog(null,
						"Czy wykonać następną operację?") >= 1) {
					throw new Exception(
							"Dziękujemy za skorzystanie z usług sieci.");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				break;
			}
		}
		System.out.println("exit");
	}
}
