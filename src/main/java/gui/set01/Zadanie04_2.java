package gui.set01;

import gui.set01.zadanie04_2.*;

/**
 * Zadanie- 1: znajdywanie hasła
 *
 * ( max. 10 p)
 *
 * W firmie pracuje kilka osób. Któraś z nich zabezpieczyła hasłem dostęp do
 * komputera z danymi o wynalazku.
 * Wiadomo, że hasło zawiera inicjały osoby i następujące po nich 6 cyfr.
 * Dwie siatki szpiegowskie próbują złamać hasło.
 * Jedna  z nich stosuje automatyczny kod, który generuje wszystkie możliwe
 * kombinacje: inicjały i sześć dowolnych cyfr, opierając się przy tym tylko
 * na znajomości inicjałów pracowników.
 * Druga uzyskała informację, że cyfry zawsze oznaczają RRMMDD - rok, miesiąc,
 * dzień urodzenia pracownika i próbuje złamać hasło "ręcznie", wprowadzając
 * kolejne możliwe warianty hasła.
 *
 * Napisać program, który:
 *
 * Na podstawie podanego zestawu pracowników i informacji o ich datach urodzenia
 * losowo generuje haslo w postaci xxRRMMDD, gdzie xx - inicjały, RR - rok, MM
 * - miesiąc, DD - dzień urodzaniea  i zamyka tym haslem dostęp do danych,
 *
 * Grupa A. generuje automatycznie kolejno wszystkie możliwe hasła, opierając
 * się tylko na informacji o inicjałach pracowników oraz że hasło po inicjałach
 * zawiera sześć dowolnych cyfr i sprawdza, czy któreś z nich pasuje do
 * prawdziwego hasła, jeśli tak, to program kończy działanie i wypisywane jest
 * prawdziwe haslo (tak działa siatka szpiegowska nr 1).
 *
 * Grupa B. w pętli tworzy okienka dialogowe przez które wprowadza  haslo,
 * próbując je zgadnąć, opierając się na podanych inicjałach i datach urodzin
 * (nie ma gwarancji że inicjały i daty odpowiadają sobie kolejnością)
 * (tak działa siatka szpiegowska 2).
 *
 * Część A należy zrealizowac jako działąjącą współbieżnie z częścią B.
 *
 * Należy przy tym  podzielić pracę w części A pomiędzy wątki, których liczba
 * podawana jest jako argument wywołania aplikacji. Należy zmierzyć czas
 * odnalezienia hasła w sytuacjach, gdy w części A zajmuje się tym jeden wątek,
 * albo 2 albo 10, albo 100 albo jeszcze inna ich liczba.
 * Sprawdzić co ew. jest potrzebne, by większa liczba wątków szybciej mogła
 * odnaleźć właściwe hasło. Zapewnić też, by wraz z wątkami części A działała
 * równocześnie  część dialogowa B.
 *
 * Uwaga: spróbować podzielić kod pomiędzy klasy, odpowiadające jego
 * funkcjonalnym częściom - np. pracownicy, zasób zamknięty hasłem,
 * automatyczny generator i sprawdzaacz haseł, część dialogowa.
 *
 * @author s8376
 */
public class Zadanie04_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int employees, threads;

		try {
			employees = Integer.parseInt(args[0]); // liczba pracownikow
		} catch (ArrayIndexOutOfBoundsException e) {
			employees = 10;
		}
		try {
			threads = Integer.parseInt(args[1]); // liczba watkow - manualna
		} catch (ArrayIndexOutOfBoundsException e) {
			threads = 0;
		}

		Employee employee = new Employee(employees);
		Password password = new Password();

		password.generate(employee.getStorage());

		System.out.println("Wylosowane haslo: " + password.getPassword());

		GroupAMaster groupAMaster = new GroupAMaster(threads);
		GroupB groupB = new GroupB(password, employee.getInitials());

		Timer timer = new Timer(password);
		timer.start();

		groupAMaster.startGroups(password, employee.getInitials());
		groupB.setPriority(8);
		groupB.start();
	}
}
