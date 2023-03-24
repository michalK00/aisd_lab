package L1.z4;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class main {

    public static void main(String[] args) {

        Pomiar[] pomiary = new Pomiar[10];
        pomiary[0] = new Pomiar(new Czas(2002, 12, 2, 23, 38), 36);
        pomiary[1] = new Pomiar(new Czas(2012, 1, 22, 23, 38), 36);
        pomiary[2] = new Pomiar(new Czas(2012, 1, 23, 11, 3), 20);
        pomiary[3] = new Pomiar(new Czas(2012, 12, 24, 23, 38), 10);
        pomiary[4] = new Pomiar(new Czas(2018, 6, 1, 15, 40), 30);
        pomiary[5] = new Pomiar(new Czas(2018, 6, 2, 23, 12), 36);
        pomiary[6] = new Pomiar(new Czas(2018, 6, 3, 3, 8), 38);
        pomiary[7] = new Pomiar(new Czas(2019, 9, 16, 19, 4), 17);
        pomiary[8] = new Pomiar(new Czas(2019, 9, 17, 18, 25), 20);
        pomiary[9] = new Pomiar(new Czas(2020, 4, 8, 12, 40), 20);

        CiągPomiarów ciągPomiarów = new CiągPomiarów(pomiary);

        System.out.println("Wprowadzenie początkowych danych:");
        printArray(ciągPomiarów);
        writeToFile(ciągPomiarów);
        System.out.println("Odczytanie danych z pliku:");
        printArray(readFromFile());
    }

    public static void printArray(CiągPomiarów ciągPomiarów) {

        for (int x = 0; x < ciągPomiarów.getPomiary().length; x++) {
            System.out.println(ciągPomiarów.getPomiary()[x]);
        }
    }

    public static void writeToFile(CiągPomiarów ciągPomiarów) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pomiary.ser"));
            out.writeObject(ciągPomiarów);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static CiągPomiarów readFromFile() {
        CiągPomiarów listaPomiarow = null;
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream("pomiary.ser"));
            listaPomiarow = (CiągPomiarów) read.readObject();
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaPomiarow;
    }
}

