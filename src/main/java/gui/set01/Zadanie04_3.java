package gui.set01;

/**
 * Zadanie-2: producent - konsument
 *
 * (max. 10p)
 *
 * Producent produkuje porcje i umieszcza je w buforze, a konsument pobiera
 * je stamtąd. Bufor przechowuje porcje w kolejności wkładania ich przez
 * producenta. Dostęp do bufora może mieć w danej chwili tylko jeden producent
 * lub konsument.
 *
 * Zadanie
 * Używając wątków napisz program symulujący współdziałanie producentów
 * i konsumentów:
 *
 * 1. Jeden producent i jeden konsument. Porcje jednakowej wielkości, bufor
 * nieograniczonej pojemności.
 * 2. Bufor o ograniczonej pojemności.
 * 3. Wielu producentów i/lub konsumentów.
 * 4. Producent produkuje i wstawia do bufora porcje różnej wielkości. Konsument
 * żąda porcji określonej wielkości. (warianty: większej lub mniejszej
 * niż podana wielkość).
 * 5. Producent nie doprowadza do nadprodukcji-nie produkuje jezeli konsumenci
 * nie skonsumowali jeszcze poprzedniej produkcji
 *
 * Wyjaśnienia
 *
 * * Bufor jest obiektem klasy Bufor. W najprostszym przypadku wkładanie porcji
 * polega na wywołaniu metody void wstaw() , która będzie zwiększać zmienną
 * całkowitą informującą o liczbie porcji, a wyjmowanie będzie ją zmniejszać
 * (np. metodą void pobierz() ).
 * * W przypadku porcji różnych wielkości powyższe metody powinny mieć argument
 * typu int.
 * * W trudniejszym przypadku, bufor zawiera tablicę obiektów klasy Porcja.
 * Porcje mogą być różnej wielkości.
 * * Producent jest wątkiem opartym na obiekcie klasy Producent. W trakcie
 * działania, w pętli wykonuje następujące operacje:
 * 1. produkuje porcję (w praktyce zasypia na jakiś czas)
 * 2. wstawia ją do bufora
 * * Konsument jest wątkiem opartym na obiekcie klasy Konsument. W trakcie
 * działania, w pętli wykonuje następujące operacje:
 * 1. pobiera porcję z bufora (jeśli jest pusty, to czeka)
 * 2. konsumuje porcję (w praktyce zasypia na jakiś czas)
 * * W metodzie main(...) należy uruchomić wątki producenta, konsumenta i bufora.
 * * Jeśli bufor jest pusty, to konsument czaka na pojawienie się towaru.
 * * Jeśli bufor jest pełny, to producent czeka na zwolnienie miejsca na porcję
 * (dotyczy przypadku bufora ograniczonego).
 *
 * Uwagi
 *
 * * Program powinien w trakcie działania wyprowadzać na konsolę dużo informacji
 * diagnostycznych, aby można było śledzić jego zachowanie.
 * * Celem zadania jest zapewnienie właściwej synchronizacji wątków, przy czym:
 * 1. Nie wolno z góry zakładać nic na temat kolejności wkładania/wyjmowania
 * z bufora.
 * 2. Nie wolno dopuścić do zjawiska blokady, kiedy żaden z wątków nie może
 * wykonać akcji. Takie zjawisko może zajść, jeśli popełni się błędy logiczne
 * w synchronizacji wątków.
 * 3. Nie wolno dopuścić do zjawiska zagłodzenia jakiegokolwiek wątku, kiedy
 * jest on ignorowany w konkurowaniu o dostęp do bufora. W zasadzie zapewnia
 * to właściwie użyta synchronizacja.
 * * Nie można doprowadzić do sytuacji, gdy bufor będzie miał liczbę porcji
 * mniejszą niż 0. Jeśli bufor ma ograniczoną pojemność, to nie może się
 * przepełnić.
 *
 * Problem producenta-kosumenta jest klasycznym przykładem z teorii
 * współbieżności. Wiele praktycznych sytuacji, w których konieczne jest
 * użycie mechanizmów współbieżności sprowadza się do tego schematu - dlatego
 * warto go głębiej zrozumieć.
 *
 * Przykład programu producent-konsument:
 *
 * class ProdConsDemo {
 * int buffer = 0;
 * final Object lock = new Object();
 * class Consumer implements Runnable {
 * int volume; //wielkość konsumpcji
 * Consumer(int v) { volume = v; }
 * public void run(){
 * while(true){
 * synchronized(lock){//!
 * while(buffer < volume){
 * try { lock.wait(); }
 * catch(InterruptedException e){ }
 * }
 * buffer -= volume;
 * } //synchronized(lock)
 * } //while
 * } //run()
 * } //class Consumer
 *
 *
 *
 * class Producer implements Runnable {
 * int volume; //wielkość produkcji
 * Producer(int v)   { volume = v;   }
 * public void run(){
 * while(true){
 * synchronized(lock){
 * buffer += volume;
 * lock.notify();
 * }
 * }
 * }
 * }
 *
 * ProdConsDemo()     {
 * new Thread(new Producer(1)).start();
 * new Thread(new Producer(2)).start();
 * new Thread(new Consumer(1)).start();
 * new Thread(new Consumer(2)).start();
 * new Thread(new Consumer(3)).start();
 * }
 * public static void main(String[] args)     {
 * new ProdConsDemo();
 * }
 * }
 *
 * @author s8376
 * @todo todo
 */
public class Zadanie04_3 {

}
