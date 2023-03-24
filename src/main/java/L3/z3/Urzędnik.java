package L3.z3;

public class Urzędnik {

    private boolean isFree;
    private String name;
    private Klient currentKlient;

    public Urzędnik(String name) {
        isFree = true;
        this.name = name;
        currentKlient = null;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Klient getCurrentKlient() {
        return currentKlient;
    }

    public void setCurrentKlient(Klient currentKlient) {
        this.currentKlient = currentKlient;
    }
}
