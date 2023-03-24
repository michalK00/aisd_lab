package L1.z1;

import java.util.Iterator;

public class StudentList {

    private Student[] list;
    Iterator<Student> studentIterator;

    public StudentList(Student[] list) {
        this.list = list;

    }

    public Student[] getList() {
        return list;
    }

    public void printWholeList(){
        System.out.println("Pełna lista studentów:");
        studentIterator = new ArrayIterator<Student>(list);
        while(studentIterator.hasNext()) {
            System.out.println(studentIterator.next().toString());
        }
    }
    public void setGradeForSpecificStudent(int indexNumber, double grade){
        Predicate<Student> predicate = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.getIndexNumber()==indexNumber;
            }
        };
        studentIterator = new ArrayIterator<Student>(list);
        FilterIterator<Student> filterIterator=new FilterIterator<Student>(studentIterator, predicate);
        if(filterIterator.hasNext() && grade>=2.0 && grade<=5.5){
            filterIterator.next().setGrade(grade);
            System.out.println("Grade changed");
        } else if(!(grade>=2.0 && grade<=5.5)){
            System.out.println("Wrong grade value");
        } else
            System.out.println("No such index number exists!");


    }
    public double calculateAverageGrade(){
        studentIterator = new ArrayIterator<Student>(list);
        int temp =0;
        double average =0;


        Predicate<Student> predicate = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.getGrade()>=3.0;
            }
        };
        FilterIterator<Student> filterIterator=new FilterIterator<Student>(studentIterator, predicate);
        while(filterIterator.hasNext()) {

            Student student = filterIterator.next();

            if(student.getGrade()==0){
                return 0;
            }

            average+=student.getGrade();
            temp++;
        }
        return average/temp;
    }
    public void printStudentsWithGradeBelowThree(){
        studentIterator = new ArrayIterator<Student>(list);
        System.out.println("Lista studentów z ocenami poniżej 3.0:");

        Predicate<Student> predicate = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.getGrade()<3.0;
            }
        };
        FilterIterator<Student> filterIterator=new FilterIterator<Student>(studentIterator, predicate);

        while (filterIterator.hasNext()){
           System.out.println(filterIterator.next());
        }
    }
}
