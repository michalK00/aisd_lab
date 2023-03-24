package L1.z1;

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
        System.out.println("INPUT:");
        studentList.printWholeList();
        System.out.println();
        System.out.println("Average grade for all students:");
        System.out.println(Math.round(studentList.calculateAverageGrade()*100.0)/100.0);
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
        System.out.println();
        studentList.printWholeList();


    }
}
