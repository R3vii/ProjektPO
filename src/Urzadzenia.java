public class Urzadzenia {
    protected String nazwa;

    public Urzadzenia(String name) {
        this.nazwa = name;
    }

    @Override
    public String toString() {
        return nazwa + " (" + getType() + ")";
    }

    // Przesłaniana metoda
    public String getType() {
        return "Urządzenie";
    }
}