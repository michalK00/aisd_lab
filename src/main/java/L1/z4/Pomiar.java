package L1.z4;

import java.io.Serializable;

public class Pomiar implements Serializable {

    private static final long serialVersionUID = 1L;

    private Czas czas;
    private double temperatura;

    public Pomiar(Czas czas, double temperatura) {
        this.czas = czas;
        this.temperatura = temperatura;
    }

    public Czas getCzas() {
        return czas;
    }

    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "Pomiar{" +
                "czas=" + czas +
                ", temperatura=" + temperatura +
                '}';
    }
}
