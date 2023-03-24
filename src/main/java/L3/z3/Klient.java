package L3.z3;

import java.util.Random;

public class Klient {

    Random random = new Random();
    private int arrivalTime;
    private int processingTime;


    public Klient() {
        arrivalTime = random.nextInt(10)+1;
        processingTime = random.nextInt(20)+1;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "arrivalTime=" + arrivalTime +
                ", processingTime=" + processingTime +
                '}';
    }
}
