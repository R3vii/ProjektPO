import java.util.ArrayList;

public class Pokoj {
    private String nazwa;
    private ArrayList<Urzadzenia> urzadzenias = new ArrayList<>();

    public Pokoj(String name) {
        this.nazwa = name;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void addDevice(Urzadzenia device) {
        urzadzenias.add(device);
    }

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
