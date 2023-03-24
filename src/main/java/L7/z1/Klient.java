package L7.z1;

import java.util.Random;

public class Klient{

    Random random = new Random();
    private int processingTime;
    private int progress;


    public Klient() {
        processingTime = random.nextInt(20)+1;
        progress = 0;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Klient{" +
                " processingTime=" + processingTime +
                '}';
    }
}
