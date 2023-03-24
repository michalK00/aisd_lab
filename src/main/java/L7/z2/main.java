package L7.z2;

import L7.z2.Comparators.ComparatorInterace;
import L7.z2.Comparators.NaturalComparator;

public class main {
    public static void main(String[] args) {
        ComparatorInterace comp = new NaturalComparator();
        Dictionary dictionary = new Dictionary(comp, 3);

        System.out.println("Array length after constructing: " + dictionary.getTab().length);
        System.out.println();
        dictionary.add(new Student("Adam", "Adamowski", 7));
        dictionary.add(new Student("Bartosz", "Bartoszewski", 3));
        dictionary.add(new Student("Cyprian", "Cypriański", 4));
        dictionary.add(new Student("Dariusz", "Dariuszewski", 1));
        dictionary.add(new Student("Edward", "Edwardowski", 5));
        dictionary.add(new Student("Fabian", "Fabianowski", 6));
        dictionary.add(new Student("Grzegorz", "Grzegowski", 2));
        dictionary.viewDictionary();
        System.out.println();
        System.out.println("Array length after adding elements that overfill the initial 2*size: " + dictionary.getTab().length);

        System.out.println();

        Student s1 = new Student("Adam", "Adamski", 20);
        Student s2 = new Student("Grzegorz", "Grzegowski", 2);
        System.out.println("Check if a certain student is in the dictionary, if yes return it's index (-1 means no)");
        System.out.println();
        System.out.println("Check " + s1);
        System.out.println("Exists: " + dictionary.contains(s1));
        System.out.println("Index of the searched key: " + dictionary.indexOf(s1));
        System.out.println();
        System.out.println("Check " + s2);
        System.out.println("Exists: " + dictionary.contains(s2));
        System.out.println("Index of the searched key: " + dictionary.indexOf(s2));
    }
}
