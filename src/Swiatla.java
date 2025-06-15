//Klasa która reprezentuje urządzenie do oświetlania pomieszczenia
public class Swiatla extends Urzadzenia {
    private boolean wlanczone; //Zmienna która świadczy o tym czy jest włączone czy wyłączone

    //Konstruktor który tworzy nowe oświetlenie
    public Swiatla(String name) {
        super(name);
        this.wlanczone = false;
    }

    //Implementacja metody abstrakcyjnej
    @Override
    public String getType() {
        return "Oświetlenie";
    }
    //Tekstowy opis swiatla i tego czy jest włączone czy nie
    @Override
    public String toString() {
        return super.toString() + " - " + (wlanczone ? "Włączone" : "Wyłączone");
    }
}