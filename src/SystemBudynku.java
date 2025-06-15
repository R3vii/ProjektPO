import java.util.ArrayList;
import java.util.Scanner;

public class SystemBudynku {
    private ArrayList<Budynek> bydyneks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Przeciążenie
    public void dodajBudynek() {
        System.out.print("Podaj nazwę budynku: ");
        String name = scanner.nextLine();
        bydyneks.add(new Budynek(name));
        System.out.println("Dodano budynek");
    }

    public void dodajBudynek(String name) {
        bydyneks.add(new Budynek(name));
    }

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

            System.out.print("Podaj nazwę pomieszczenia: ");
            String roomName = scanner.nextLine();

            bydyneks.get(buildingIndex).dodajPokoj(new Pokoj(roomName));
            System.out.println("Dodano pomieszczenie");
        } catch (NumberFormatException e) {
            System.out.println("Spróbuj ponownie wpisać *liczbę*");
        }
    }

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

    public void dodajUrzadzenia() {
        pokazPokoje();
        if (bydyneks.isEmpty()) {
            System.out.println("Najpierw dodaj budynek i pomieszczenie");
            return;
        }
        try {
            System.out.print("Wybierz numer budynku: ");
            int buildingIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (buildingIndex < 0 || buildingIndex >= bydyneks.size()) {
                System.out.println("Nieprawidłowy numer budynku");
                return;
            }

            System.out.print("Wybierz numer pomieszczenia: ");
            int roomIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (roomIndex < 0 || roomIndex >= bydyneks.get(buildingIndex).getPokoje().size()) {
                System.out.println("Nieprawidłowy numer pomieszczenia");
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
