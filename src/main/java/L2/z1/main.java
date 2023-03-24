package L2.z1;

public class main {

    public static void main(String[] args) {
        OneWayLinkedListWithHead<Student> list = new OneWayLinkedListWithHead<>();

        Student s1 = new Student("Adam","Adamowski",123,5.0);
        Student studentKtoregoNieMa = new Student("Edward", "Edwardowski", 021, 3.0);

        list.add(s1);
        list.add(s1);
        list.add(new Student("Bartosz","Bartoszewski",321,4.0));
        list.add(new Student("Cyprian","Cyprianowski",111,2.0));
        list.add(new Student("Damian","Damianowski",999,3.0));
        list.add(s1);
        System.out.println("INPUT:");
        list.printWholeList();

        System.out.println();


        System.out.println("Usuwanie wszystkich takich samych obiektów w tablicy równych:" + s1 );
        list.removeAllObjectsWithKey(s1);
        System.out.println("OUTPUT:");
        list.printWholeList();
        System.out.println();
        System.out.println("Usuwanie wszystkich takich samych obiektów w tablicy równych: " + studentKtoregoNieMa + " tego studenta nie ma na liście");
        list.removeAllObjectsWithKey(studentKtoregoNieMa);
        System.out.println("OUTPUT:");
        list.printWholeList();
        System.out.println();

        System.out.println("Zapisywanie do listy:");
        ListSerialize.save(list);
        System.out.println("Odczytywanie z listy:");
        System.out.println("Wypisywanie odczytaniej listy:");
        ListSerialize.read().printWholeList();





    }
}
