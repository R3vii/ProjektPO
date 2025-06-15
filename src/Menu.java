import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private SystemBudynku systemBudynku = new SystemBudynku();

    public void start() {
        while (true) {
            try {
                System.out.println("\n=== System Zarządzania Budynkiem ===");
                System.out.println("1. Dodaj budynek");
                System.out.println("2. Wyświetl budynki");
                System.out.println("3. Dodaj pomieszczenie");
                System.out.println("4. Wyświetl pomieszczenia");
                System.out.println("5. Dodaj urządzenie");
                System.out.println("6. Wyświetl urządzenia");
                System.out.println("0. Wyjście");
                System.out.print("Wybierz opcję: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        systemBudynku.dodajBudynek();
                        break;
                    case "2":
                        systemBudynku.pokazBudynki();
                        break;
                    case "3":
                        systemBudynku.dodajPokoj();
                        break;
                    case "4":
                        systemBudynku.pokazPokoje();
                        break;
                    case "5":
                        systemBudynku.dodajUrzadzenia();
                        break;
                    case "6":
                        systemBudynku.pokazUrzadzenia();
                        break;
                    case "0":
                        System.out.println("Koniec programu");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Nieprawidłowy wybór! Wybierz 0-6");
                }
            } catch (Exception e) {
                System.out.println("Wystąpił błąd: " + e.getMessage());
                System.out.println("Spróbuj ponownie");
            }
        }
    }
}