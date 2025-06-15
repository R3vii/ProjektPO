//Klasa która reprezentuje urządzenie do ustawiania temperatury w pomieszczeniu
public class Termostat extends Urzadzenia {
    private int temperatura = 20; //Aktualnie ustawiona temperatura (domyślna)

    //Konstruktor tworzący nowy termostat
    public Termostat(String name) {
        super(name);
    }
    //Metoda zwracająca typ urządzenia
    @Override
    public String getType() {
        return "Termostat";
    }

    //Tekstowy opis termostatu z temperaturą
    @Override
    public String toString() {
        return super.toString() + " - " + temperatura + "°C";
    }
}