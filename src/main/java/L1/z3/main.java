package L1.z3;

public class main {


    public static void main(String [] args){
        Student[] list = new Student[10];
        list[0]= new Student("Adam", "Kowalski",123456,3.0);
        list[1]= new Student("Jakub", "Nowak",262612,4.0);
        list[2]= new Student("Tomasz", "Kowalczyk",266821,4.5);
        list[3]= new Student("Dawid", "Nowacki",368131,2.5);
        list[4]= new Student("Anna", "Kowal",434721,2.0);
        list[5]= new Student("Kamil", "Wócik",461411,5.0);
        list[6]= new Student("Wiktoria", "Zielińska",612561,4.0);
        list[7]= new Student("Wojciech", "Jankowski",616231,3.5);
        list[8]= new Student("Marta", "Kamińska",734151,5.0);
        list[9]= new Student("Adam", "Szymański",812341,2.0);


        StudentList studentList = new StudentList(list);
        System.out.print("INPUT: ");
        studentList.printWholeList();
        System.out.println();
        System.out.print("Average grade for every student: ");
        System.out.println(studentList.calculateAverageGrade());
        System.out.println();
        studentList.printStudentsWithGradeBelowThree();
        System.out.println();
        System.out.println("Próba wpisania oceny trzem studentom");
        System.out.println("Pierwszy istnieje i 5.5<=ocena>=2");
        System.out.println("Drugi nie istnieje i 5.5<=ocena>=2");
        System.out.println("Trzeci istnieje i ocena>5.5");
        System.out.print("1.");
        studentList.setGradeForSpecificStudent(461411,3.0);
        System.out.print("2.");
        studentList.setGradeForSpecificStudent(100000,4.0);
        System.out.print("3.");
        studentList.setGradeForSpecificStudent(812341,6.0);
        studentList.printWholeList();
        System.out.println();
        ArrayIterator<Student> iterator = new ArrayIterator<>(studentList.getList());
        System.out.println("Dodanie trzech studentów jeden juz istnieje (indexNumber = 123456):");
        iterator = studentList.addStudent(iterator,new Student("Damian", "Kowalski",123456,5.0));
        iterator = studentList.addStudent(iterator, new Student("Mateusz", "Kowalczyk",443456,4.0));
        iterator = studentList.addStudent(iterator, new Student("Alicja", "Nowak",900000,5.0));
        studentList.printWholeList();
        System.out.println();
        System.out.println("Usuwanie studenta w środku listy:");
        iterator = studentList.deleteStudent(iterator,443456);
        studentList.printWholeList();
        System.out.println();
        System.out.println("Usuwanie studenta na końcu listy:");
        iterator = studentList.deleteStudent(iterator, 900000);
        studentList.printWholeList();
        System.out.println();
        System.out.println("Usuwanie studenta spoza listy:");
        iterator = studentList.deleteStudent(iterator, 100000);
        studentList.printWholeList();
        System.out.println("Posortowana lista:");
        System.out.println("Niestety nie działa (musiałbym dłużej nad tym pomyśleć), przepraszam ale nie mam już siły na to zadanie");
        iterator = studentList.sort(iterator);
        studentList.printWholeList();



    }


}
