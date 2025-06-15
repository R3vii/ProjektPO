//Klasa która reprezentuje budynek wraz z pomieszczeniami
import java.util.ArrayList;
public class Budynek {
    private String nazwa;
    private ArrayList<Pokoj> pokoje = new ArrayList<>(); //Lista pokoi które zawiera budynek

    public Budynek(String name) {
        this.nazwa = name;
    }

    // Hermetyzacja (Gettery i settery)
    public String getNazwa() {
        return nazwa;
    }

    public ArrayList<Pokoj> getPokoje() {
        return pokoje;
    }

    // Sprawdza czy pokój o podanej nazwie już istnieje w tym budynku
    public boolean czyPokojIstnieje(String nazwaPokoju) {
        for (Pokoj pokoj : pokoje) {
            if (pokoj.getNazwa().equalsIgnoreCase(nazwaPokoju)) {
                return true;
            }
        }
        return false;
    }

    //dodawanie nowego pokoju do budynku
    public void dodajPokoj(Pokoj room) {
        pokoje.add(room);
    }

    //wyświetlanie wszystkich pokoi w budynku
    public void pokazPokoje() {
        if (pokoje.isEmpty()) {
            System.out.println("Brak pomieszczeń");
            return;
        }

        System.out.println("\nLista pomieszczeń:");
        for (int i = 0; i < pokoje.size(); i++) {
            System.out.println((i+1) + ". " + pokoje.get(i).getNazwa());
        }
    }
}
