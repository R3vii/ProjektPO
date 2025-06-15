//Klasa która zarządza uruchamianiem systemu budynku
public class BudynekManager {
    private static Menu manager = new Menu();

    //uruchomienie głównego menu systemu
    public static void run() {
        manager.start();
    }
}
