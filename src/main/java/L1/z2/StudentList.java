package L1.z2;

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
    public void addGradeForSpecificStudent(int indexNumber, double grade){
        Predicate<Student> predicate = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.getIndexNumber()==indexNumber;
            }
        };
        studentIterator = new ArrayIterator<Student>(list);
        FilterIterator<Student> filterIterator=new FilterIterator<Student>(studentIterator, predicate);
        if(filterIterator.hasNext() && grade>=2.0 && grade<=5.5){
            filterIterator.next().getGrades().add(grade);
            System.out.println("Grade added");
        } else if(!(grade>=2.0 && grade<=5.5)){
            System.out.println("Wrong grade value");
        } else
            System.out.println("No such index number exists!");
    }
    public void calculateAverageGrade(){
        System.out.println("Lista studentów z średnimi ocen powyżej 3.0 wraz z tymi średnimi:");
        studentIterator = new ArrayIterator<Student>(list);

        Predicate<Student> predicate = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.calculateAverageGrade()>=3.0;
            }
        };

        FilterIterator<Student> filterIterator=new FilterIterator<Student>(studentIterator, predicate);
        Student student;
        while (filterIterator.hasNext()){
            student = filterIterator.next();
            System.out.println(student + " średnia: " + Math.round(student.calculateAverageGrade()*100.0)/100.0);
        }
    }
    public void printStudentsWithGradeBelowThree(){
        studentIterator = new ArrayIterator<Student>(list);
        System.out.println("Lista studentów z średnimi ocen poniżej 3.0:");

        Predicate<Student> predicate = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.calculateAverageGrade()<3.0;
            }
        };
        FilterIterator<Student> filterIterator=new FilterIterator<Student>(studentIterator, predicate);
        Student student;

        while (filterIterator.hasNext()){
            student = filterIterator.next();
            System.out.println(student + " średnia: " + Math.round(student.calculateAverageGrade()*100.0)/100.0);
        }
    }
}
