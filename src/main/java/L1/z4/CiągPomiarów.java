package L1.z4;

import java.io.Serializable;

public class CiągPomiarów implements Serializable {

    private Pomiar[] pomiary;

    public CiągPomiarów() {
    }

    public CiągPomiarów(Pomiar[] pomiary) {
        this.pomiary = pomiary;
    }

    public Pomiar[] getPomiary() {
        return pomiary;
    }
}
