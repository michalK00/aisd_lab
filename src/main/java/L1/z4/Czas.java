package L1.z4;

import java.io.Serializable;

public class Czas implements Serializable {

    private static final long serialVersionUID = 2L;

    private int rok;
    private int miesiąc;
    private int dzień;
    private int godzina;
    private int minuta;

    public Czas(int rok, int miesiąc, int dzień, int godzina, int minuta) {
        this.rok = rok;
        this.miesiąc = miesiąc;
        this.dzień = dzień;
        this.godzina = godzina;
        this.minuta = minuta;
    }


    public int getRok() {
        return rok;
    }

    public int getMiesiąc() {
        return miesiąc;
    }

    public int getDzień() {
        return dzień;
    }

    public int getGodzina() {
        return godzina;
    }

    public int getMinuta() {
        return minuta;
    }

    @Override
    public String toString() {
        return "Czas{" +
                "rok=" + rok +
                ", miesiąc=" + miesiąc +
                ", dzień=" + dzień +
                ", godzina=" + godzina +
                ", minuta=" + minuta +
                '}';
    }
}
