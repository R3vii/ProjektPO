//Główna klasa systemu zarządzania budynkiem
import java.util.ArrayList;
import java.util.Scanner;

public class SystemBudynku {
    private ArrayList<Budynek> bydyneks = new ArrayList<>(); //Lista wszystkich budynków
    private Scanner scanner = new Scanner(System.in); //Skaner który służy do wprowadzania danych

    // Przeciążenie
    public void dodajBudynek() {
        System.out.print("Podaj nazwę budynku: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Błąd: Nazwa budynku nie może być pusta");
            return;
        }

        if (czyBudynekIstnieje(name)) {
            System.out.println("Błąd: Budynek o tej nazwie już istnieje");
            return;
        }

        bydyneks.add(new Budynek(name));
        System.out.println("Pomyślnie dodano budynek");
    }

    // Sprawdza czy budynek o podanej nazwie już istnieje
    private boolean czyBudynekIstnieje(String nazwa) {
        for (Budynek budynek : bydyneks) {
            if (budynek.getNazwa().equalsIgnoreCase(nazwa)) {
                return true;
            }
        }
        return false;
    }

    //Przeciążona metoda (która dodaje budynek)
    public void dodajBudynek(String name) {
        if (!name.trim().isEmpty() && !czyBudynekIstnieje(name)) {
            bydyneks.add(new Budynek(name));
        }
    }

    // Wyświetlanie listy wszystkich budynków
    public void pokazBudynki() {
        if (bydyneks.isEmpty()) {
            System.out.println("Brak budynków");
            return;
        }

        System.out.println("\nLista budynków:");
        for (int i = 0; i < bydyneks.size(); i++) {
            System.out.println((i+1) + ". " + bydyneks.get(i).getNazwa());
        }
    }

    //Metoda dodająca pomieszczenie do wybranego budynku
    public void dodajPokoj() {
        pokazBudynki();
        if (bydyneks.isEmpty()) return;

        try {
            System.out.print("Wybierz numer budynku: ");
            int buildingIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (buildingIndex < 0 || buildingIndex >= bydyneks.size()) {
                System.out.println("Nieprawidłowy numer budynku");
                return;
            }

            System.out.print("Podaj nazwę pokoju: ");
            String roomName = scanner.nextLine().trim();

            if (roomName.isEmpty()) {
                System.out.println("Błąd: Nazwa pokoju nie może być pusta");
                return;
            }

            Budynek wybranyBudynek = bydyneks.get(buildingIndex);
            if (wybranyBudynek.czyPokojIstnieje(roomName)) {
                System.out.println("Błąd: Pokój o tej nazwie już istnieje w tym budynku");
                return;
            }

            wybranyBudynek.dodajPokoj(new Pokoj(roomName));
            System.out.println("Dodano pokój");
        } catch (NumberFormatException e) {
            System.out.println("Spróbuj ponownie wpisać *liczbę*");
        }
    }

    //Metoda wyświetlająca listę pomieszczeń w wybranym budynku
    public void pokazPokoje() {
        pokazBudynki();
        if (bydyneks.isEmpty()) return;

        try {
            System.out.print("Wybierz numer budynku: ");
            int buildingIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (buildingIndex < 0 || buildingIndex >= bydyneks.size()) {
                System.out.println("Nieprawidłowy numer budynku");
                return;
            }

            bydyneks.get(buildingIndex).pokazPokoje();
        } catch (NumberFormatException e) {
            System.out.println("Spróbuj ponownie wpisać *liczbę*");
        }
    }

    //Dodaje nowe urządzenie do wybranego pokoju
    public void dodajUrzadzenia() {
        pokazPokoje();
        if (bydyneks.isEmpty()) {
            System.out.println("Najpierw dodaj budynek i pokój");
            return;
        }
        try {
            System.out.print("Wybierz numer budynku: ");
            int buildingIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (buildingIndex < 0 || buildingIndex >= bydyneks.size()) {
                System.out.println("Nieprawidłowy numer budynku");
                return;
            }

            System.out.print("Wybierz numer pokoju: ");
            int roomIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (roomIndex < 0 || roomIndex >= bydyneks.get(buildingIndex).getPokoje().size()) {
                System.out.println("Nieprawidłowy numer pokoju");
                return;
            }

            System.out.print("Podaj typ urządzenia (swiatlo/termostat): ");
            String type = scanner.nextLine();

            if (!type.equalsIgnoreCase("swiatlo") && !type.equalsIgnoreCase("termostat")) {
                System.out.println("Wystąpił błąd, możesz wybrać jedną z dwóch opcji 'swiatlo' lub 'termostat'");
                return;
            }

            System.out.print("Podaj nazwę urządzenia: ");
            String name = scanner.nextLine();

            if (type.equalsIgnoreCase("swiatlo")) {
                bydyneks.get(buildingIndex).getPokoje().get(roomIndex)
                        .addDevice(new Swiatla(name));
            } else if (type.equalsIgnoreCase("termostat")) {
                bydyneks.get(buildingIndex).getPokoje().get(roomIndex)
                        .addDevice(new Termostat(name));
            } else {
                System.out.println("Nieznany typ urządzenia");
                return;
            }

            System.out.println("Dodano urządzenie");
        } catch (NumberFormatException e) {
            System.out.println("Spróbuj wpisać *liczbę* ponownie ");
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
        }
    }

    //Wyświetlanie listy urządzeń w wybranym pomieszczeniu
    public void pokazUrzadzenia() {
        pokazPokoje();
        if (bydyneks.isEmpty()) return;

        System.out.print("Wybierz numer budynku: ");
        int buildingIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Wybierz numer pomieszczenia: ");
        int roomIndex = Integer.parseInt(scanner.nextLine()) - 1;

        bydyneks.get(buildingIndex).getPokoje().get(roomIndex).showDevices();
    }
}
