public class Swiatla extends Urzadzenia {
    private boolean wlanczone;

    public Swiatla(String name) {
        super(name);
        this.wlanczone = false;
    }

    @Override
    public String getType() {
        return "Oświetlenie";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + (wlanczone ? "Włączone" : "Wyłączone");
    }
}