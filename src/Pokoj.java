import java.util.ArrayList;
//Klasa która reprezentuje pokoje (i dołączone urządzenia, jeśli posiada)
public class Pokoj {
    private String nazwa; //Nazwa danego pokoju
    private ArrayList<Urzadzenia> urzadzenias = new ArrayList<>(); //Lista urządzeń
    //Konstruktor który tworzy nowe pomieszczenie
    public Pokoj(String name) {
        this.nazwa = name;
    }

    public String getNazwa() {
        return nazwa;
    }

    //dodaje urządzenie do pokoju
    public void addDevice(Urzadzenia device) {
        urzadzenias.add(device);
    }

    //Pokazuje urządzenia w pokoju
    public void showDevices() {
        if (urzadzenias.isEmpty()) {
            System.out.println("Brak urządzeń");
            return;
        }

        System.out.println("\nLista urządzeń:");
        for (int i = 0; i < urzadzenias.size(); i++) {
            System.out.println((i+1) + ". " + urzadzenias.get(i));
        }
    }
}
