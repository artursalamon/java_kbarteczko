package gui.set02.ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * DataHandler
 */
public class DataHandler {

	private String path;
	private List<Client> storage;

	/**
	 * @param path
	 */
	public DataHandler(String path) {
		storage = new ArrayList<Client>();
		this.path = path;
		readFile();
	}

	/**
	 *
	 */
	public void readFile() {

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;

			while ((line = br.readLine()) != null) {
				String[] rowData = line.split(";");
				storage.add(new Client(
						Integer.parseInt(rowData[0]),
						Integer.parseInt(rowData[1]),
						Integer.parseInt(rowData[2]),
						Integer.parseInt(rowData[3]),
						Long.parseLong(rowData[4])
				));
			}

			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *
	 */
	public void writeFile() {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			String line;

			for (Client client : storage) {
				bw.write(client.prepareToModel());
				bw.newLine();
			}

			bw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @param pin
	 * @return
	 * @throws Exception
	 */
	public Client getAccount(Integer pin) throws Exception {

		boolean found = false;

		for (Client client : storage) {
			if (client.authByPIN(pin)) {
				return client;
			}
		}

		throw new Exception("Nie znaleziono konta");
	}
}
