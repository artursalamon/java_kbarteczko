package gui.set01.zadanie01_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Model
 */
public class Model {

	protected String path;
	protected ArrayList<Hashtable<String, String>> storage;

	/**
	 * @param path
	 */
	public Model(String path) {
		this.path = path;
	}

	/**
	 * @throws Exception
	 */
	protected void read() throws Exception {

		String line;
		String[] array;
		Hashtable<String, String> table;

		try {
			storage = new ArrayList<Hashtable<String, String>>();
			BufferedReader br = new BufferedReader(new FileReader(path));

			// numer karty;PIN;saldo;l.wyplata;limit na dzien;licznik wyplat: dzien; data odstaniej wyplaty
			// 555123112312313;1234;650.23;500;1500;0;Sun Mar 06 12:50:07 CET 2011

			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					array = line.split("[;]+");
					table = new Hashtable<String, String>();

					table.put("cardNum", array[0]);
					table.put("pin", array[1]);
					table.put("balance", array[2]);
					table.put("limitPerOnce", array[3]);
					table.put("limitPerDay", array[4]);
					table.put("counterDay", array[5]);
					table.put("timeLastUsage", array[6]);

					storage.add(table);
				}
			}

			br.close();
		} catch (Exception e) {
			throw new Exception("Błąd połączenia z bazą danych");
		}
	}

	/**
	 * @param cardNum
	 * @return
	 * @throws Exception
	 */
	public Hashtable<String, String> getAccount(String cardNum) throws Exception {

		if (storage == null) {
			read();
		}
		for (Hashtable<String, String> val : storage) {
			if (val.get("cardNum").equals(cardNum)) {
				return val;
			}
		}
		throw new Exception("Nie odnaleziono danych karty " + cardNum);
	}

	/**
	 * @throws Exception
	 */
	public void setAccount() throws Exception {
		if (storage == null) {
			throw new Exception("Błąd połączenia z bazą danych");
		}

		write();
	}

	/**
	 * @throws Exception
	 */
	public void write() throws Exception {

		String sep = ";";

		BufferedWriter bw = new BufferedWriter(new FileWriter(path));

		for (Hashtable<String, String> val : storage) {
			bw.write(val.get("cardNum") + sep + val.get("pin") + sep
					+ val.get("balance") + sep + val.get("limitPerOnce") + sep
					+ val.get("limitPerDay") + sep + val.get("counterDay")
					+ sep + val.get("timeLastUsage"));
			bw.newLine();
		}

		bw.close();
	}
}
