public class Termostat extends Urzadzenia {
    private int temperatura = 20;

    public Termostat(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Termostat";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + temperatura + "°C";
    }
}