package L7.z4;

import L7.z4.Comparators.ComparatorInterace;
import L7.z4.Comparators.NaturalComparator;


public class main {
    public static void main(String[] args) {
        ComparatorInterace comp = new NaturalComparator();
        HashDictionaryWithLinkedList hashDictionaryWithLinkedList = new HashDictionaryWithLinkedList(comp, 2);

        System.out.println("Array length after constructing: " + hashDictionaryWithLinkedList.getTab().length);
        System.out.println();
        hashDictionaryWithLinkedList.add(new Student("Adam", "Adamowski", 7));
        hashDictionaryWithLinkedList.add(new Student("Bartosz", "Bartoszewski", 3));
        hashDictionaryWithLinkedList.add(new Student("Cyprian", "Cypriański", 4));
        hashDictionaryWithLinkedList.add(new Student("Dariusz", "Dariuszewski", 1));
        hashDictionaryWithLinkedList.add(new Student("Edward", "Edwardowski", 5));
        hashDictionaryWithLinkedList.add(new Student("Fabian", "Fabianowski", 6));
        hashDictionaryWithLinkedList.add(new Student("Grzegorz", "Grzegowski", 2));
        hashDictionaryWithLinkedList.add(new Student("Hubert", "Hubertowski", 11));
        hashDictionaryWithLinkedList.add(new Student("Igor", "Igorowski", 9));
        hashDictionaryWithLinkedList.add(new Student("Jan", "Janowski", 14));
        hashDictionaryWithLinkedList.add(new Student("Kamil", "Kamilowski", 12));
        hashDictionaryWithLinkedList.add(new Student("Leon", "Leonowski", 8));
        hashDictionaryWithLinkedList.add(new Student("Michał", "Michałowski", 10));
        hashDictionaryWithLinkedList.add(new Student("Norbert", "Norbertowski", 13));
        hashDictionaryWithLinkedList.viewDictionary();
        System.out.println();
        System.out.println("Array length after adding elements that overfill the initial 2*size: " + hashDictionaryWithLinkedList.getTab().length);

        System.out.println();

        Student s1 = new Student("Adam", "Adamski", 20);
        Student s2 = new Student("Grzegorz", "Grzegowski", 2);
        System.out.println("Check if a certain student is in the dictionary, if yes return it's index (-1 means no)");
        System.out.println();
        System.out.println("Check " + s1);
        System.out.println("Index of the searched key: " + hashDictionaryWithLinkedList.indexOf(s1));
        System.out.println();
        System.out.println("Check " + s2);
        System.out.println("Index of the searched key: " + hashDictionaryWithLinkedList.indexOf(s2));
    }
}
