package L7.z3;

import L7.z3.Comparators.ComparatorInterace;
import L7.z3.Comparators.NaturalComparator;


public class main {
    public static void main(String[] args) {
        ComparatorInterace comp = new NaturalComparator();
        HashDictionary hashDictionary = new HashDictionary(comp, 3);

        System.out.println("Array length after constructing: " + hashDictionary.getTab().length);
        System.out.println();
        hashDictionary.add(new Student("Adam", "Adamowski", 7));
        hashDictionary.add(new Student("Bartosz", "Bartoszewski", 3));
        hashDictionary.add(new Student("Cyprian", "Cypriański", 4));
        hashDictionary.add(new Student("Dariusz", "Dariuszewski", 1));
        hashDictionary.add(new Student("Edward", "Edwardowski", 5));
        hashDictionary.add(new Student("Fabian", "Fabianowski", 6));
        hashDictionary.add(new Student("Grzegorz", "Grzegowski", 2));
        hashDictionary.viewDictionary();
        System.out.println();
        System.out.println("Array length after adding elements that overfill the initial 2*size: " + hashDictionary.getTab().length);

        System.out.println();

        Student s1 = new Student("Adam", "Adamski", 20);
        Student s2 = new Student("Grzegorz", "Grzegowski", 2);
        System.out.println("Check if a certain student is in the dictionary, if yes return it's index (-1 means no)");
        System.out.println();
        System.out.println("Check " + s1);
        System.out.println("Exists: " + hashDictionary.contains(s1));
        System.out.println("Index of the searched key: " + hashDictionary.indexOf(s1));
        System.out.println();
        System.out.println("Check " + s2);
        System.out.println("Exists: " + hashDictionary.contains(s2));
        System.out.println("Index of the searched key: " + hashDictionary.indexOf(s2));
    }
}
