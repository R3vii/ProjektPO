//Klasa reprezentująca urządzenia
public class Urzadzenia {
    protected String nazwa; //Nazwa urządzenia

    //Konstruktor który tworzy nowe urządzenia
    public Urzadzenia(String name) {
        this.nazwa = name;
    }

    //Zwracanie informacji o urządzeniu
    @Override
    public String toString() {
        return nazwa + " (" + getType() + ")";
    }

    // Przesłaniana metoda
    public String getType() {
        return "Urządzenie";
    }
}