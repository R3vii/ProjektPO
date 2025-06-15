import java.util.ArrayList;

public class Budynek {
    private String nazwa;
    private ArrayList<Pokoj> pokoje = new ArrayList<>();

    public Budynek(String name) {
        this.nazwa = name;
    }

    // Hermetyzacja
    public String getNazwa() {
        return nazwa;
    }

    public ArrayList<Pokoj> getPokoje() {
        return pokoje;
    }

    public void dodajPokoj(Pokoj room) {
        pokoje.add(room);
    }

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