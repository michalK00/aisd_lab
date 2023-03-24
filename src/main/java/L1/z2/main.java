package L1.z2;

import java.util.ArrayList;

public class main {


    public static void main(String [] args){
        Student[] list = new Student[10];
        ArrayList<Double> l0 = new ArrayList<>();
        l0.add(3.0);
        l0.add(4.5);
        l0.add(2.0);
        ArrayList<Double> l1 = new ArrayList<>();
        l1.add(5.0);
        l1.add(4.0);
        l1.add(3.0);
        ArrayList<Double> l2= new ArrayList<>();
        l2.add(2.0);
        l2.add(2.5);
        l2.add(3.0);
        ArrayList<Double> l3 = new ArrayList<>();
        l3.add(5.0);
        l3.add(4.5);
        l3.add(3.5);
        ArrayList<Double> l4 = new ArrayList<>();
        l4.add(3.5);
        l4.add(5.0);
        l4.add(3.0);
        ArrayList<Double> l5 = new ArrayList<>();
        l5.add(2.0);
        l5.add(3.5);
        l5.add(4.0);
        ArrayList<Double> l6 = new ArrayList<>();
        l6.add(3.0);
        l6.add(3.5);
        l6.add(3.0);
        ArrayList<Double> l7 = new ArrayList<>();
        l7.add(5.0);
        l7.add(3.5);
        l7.add(5.0);
        ArrayList<Double> l8 = new ArrayList<>();
        l8.add(4.0);
        l8.add(4.5);
        l8.add(5.0);
        ArrayList<Double> l9 = new ArrayList<>();
        l9.add(5.0);
        l9.add(4.0);
        l9.add(5.0);

        list[0]= new Student("Adam", "Kowalski",123456,l0);
        list[1]= new Student("Jakub", "Nowak",262612,l1);
        list[2]= new Student("Tomasz", "Kowalczyk",266821,l2);
        list[3]= new Student("Dawid", "Nowacki",368131,l3);
        list[4]= new Student("Anna", "Kowal",434721,l4);
        list[5]= new Student("Kamil", "Wócik",461411,l5);
        list[6]= new Student("Wiktoria", "Zielińska",612561,l6);
        list[7]= new Student("Wojciech", "Jankowski",616231,l7);
        list[8]= new Student("Marta", "Kamińska",734151,l8);
        list[9]= new Student("Adam", "Szymański",812341,l9);


        StudentList studentList = new StudentList(list);

        System.out.println("INPUT:");
        studentList.printWholeList();
        System.out.println();

        studentList.calculateAverageGrade();
        System.out.println();

        studentList.printStudentsWithGradeBelowThree();
        System.out.println();
        System.out.println("Próba dopisania oceny trzem studentom");
        System.out.println("Pierwszy istnieje i 5.5<=ocena>=2");
        System.out.println("Drugi nie istnieje i 5.5<=ocena>=2");
        System.out.println("Trzeci istnieje i ocena>5.5");
        System.out.print("1.");
        studentList.addGradeForSpecificStudent(461411,3.0);
        System.out.print("2.");
        studentList.addGradeForSpecificStudent(100000,4.0);
        System.out.print("3.");
        studentList.addGradeForSpecificStudent(812341,6.0);
        System.out.println();
        studentList.printWholeList();


    }
}
