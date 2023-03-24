package L2.z3;

public class main {

    public static void main(String[] args) {

        TwoWayCycledListWithSentinel<Student> list1 = new TwoWayCycledListWithSentinel<>();
        TwoWayCycledListWithSentinel<Student> list2 = new TwoWayCycledListWithSentinel<>();
        TwoWayCycledListWithSentinel<Student> mergedList = new TwoWayCycledListWithSentinel<>();

        Student student = new Student("Adam","Nowak",536,5.0);


        fillList1(list1,student);
        fillList2(list2);
        System.out.println("Lista 1:");
        list1.printWholeList();
        System.out.println();
        System.out.println("Lista 2:");
        list2.printWholeList();
        System.out.println();

        int index = 3;
        System.out.println("Wstawianie listy2 do listy1 na: " + index + " indeksie: ");
        mergedList = list1.mergeAnotherListIntoCurrentOneMethod1(list2, index);
        System.out.println("Wypisywanie listy używając getNext():");
        mergedList.printWholeList();
        System.out.println();
        System.out.println("Wypisywanie listy używając getPrev():");
        mergedList.printWholeListBackwordsUsingGetPrev();
        System.out.println();
        mergedList.clear();

        fillList1(list1,student);
        fillList2(list2);

        index = 6;
        System.out.println("Próba wstawienia listy2 do listy1 - indeks przekracza rozmiar listy1");
        System.out.println("Wstawianie listy2 do listy1 na: " + index + " indeksie: ");
        mergedList = list1.mergeAnotherListIntoCurrentOneMethod1(list2, index);
        System.out.println("Wypisywanie listy używając getNext():");
        mergedList.printWholeList();
        System.out.println();
        System.out.println("Wypisywanie listy używając getPrev():");
        mergedList.printWholeListBackwordsUsingGetPrev();
        System.out.println();
        mergedList.clear();

        fillList1(list1,student);
        fillList2(list2);



        System.out.println("Wstawianie listy2 na koniec listy1: ");
        mergedList = list1.mergeAnotherListIntoCurrentOneMethod3(list2);
        System.out.println("Wypisywanie listy używając getNext():");
        mergedList.printWholeList();
        System.out.println();
        System.out.println("Wypisywanie listy używając getPrev():");
        mergedList.printWholeListBackwordsUsingGetPrev();
        System.out.println();
        mergedList.clear();

        fillList1(list1,student);
        fillList2(list2);

        System.out.println("Wstawianie listy2 przed obiektem");
        System.out.println(student);
        System.out.println("do listy1");
        mergedList = list1.mergeAnotherListIntoCurrentOneMethod2(list2,student);
        System.out.println("Wypisywanie listy używając getNext():");
        mergedList.printWholeList();
        System.out.println();
        System.out.println("Wypisywanie listy używając getPrev():");
        mergedList.printWholeListBackwordsUsingGetPrev();
        System.out.println();
        mergedList.clear();

        fillList1(list1,student);
        fillList2(list2);

        Student fakeStudent = new Student("Wojciech", "Wojciechowski", 997, 5.0);

        System.out.println("Wstawianie listy2 przed obiektem (który nie istnieje w tej liście): ");
        System.out.println(fakeStudent);
        System.out.println("do listy1");
        mergedList = list1.mergeAnotherListIntoCurrentOneMethod2(list2,fakeStudent);
        System.out.println("Wypisywanie listy używając getNext():");
        mergedList.printWholeList();
        System.out.println();
        System.out.println("Wypisywanie listy używając getPrev():");
        mergedList.printWholeListBackwordsUsingGetPrev();
        System.out.println();
        mergedList.clear();
    }
    public static void fillList1(TwoWayCycledListWithSentinel list1, Student student){

        list1.clear();

        list1.add(new Student("Antoni","Bartoszewski",123,5.0));
        list1.add(new Student("Adam","Łukasiewicz",234,4.0));
        list1.add(new Student("Alojzy","Wojciechowski",245,2.0));
        list1.add(student);

    }
    public static void fillList2(TwoWayCycledListWithSentinel list2){

        list2.clear();

        list2.add(new Student("Jan","Dawidowicz",225,5.0));
        list2.add(new Student("Jakub","Tomaszewski",240,4.0));
        list2.add(new Student("Janusz","Adamowicz",342,2.0));
        list2.add(new Student("Jarosław","Kamilowski",423,3.0));


    }

}
