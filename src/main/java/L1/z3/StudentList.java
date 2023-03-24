package L1.z3;

import java.util.Iterator;

public class StudentList {

    private Student[] list;
    CustomIterator<Student> studentIterator;

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
        return Math.round(average/temp*100.0)/100.0;
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

    public ArrayIterator<Student> addStudent(ArrayIterator<Student> iterator, Student passedStudent){
        Student[] updatedList = new Student[getList().length+1];
        Student student;
        int x=0;
        while(iterator.hasNext() ){
            student = iterator.next();
            if(student.getIndexNumber() == passedStudent.getIndexNumber()){
                System.out.println("Error - Student "+passedStudent.getIndexNumber()+" already exists");
                return new ArrayIterator<>(list);
            }
            if(student.getIndexNumber() > passedStudent.getIndexNumber()){
                System.out.println("Student "+ passedStudent.getIndexNumber() + " added");
                break;
            }
            x++;

        }
        System.arraycopy(list,0,updatedList,0,x);
        updatedList[x]= passedStudent;
        System.arraycopy(list,x,updatedList,x+1,list.length-x);
        list = updatedList;

        return new ArrayIterator<>(list);
    }
    public ArrayIterator<Student> deleteStudent(ArrayIterator<Student> iterator,int index){

        Student[] updatedList = new Student[getList().length-1];
        boolean exists=false;
        int x =0;
        while(iterator.hasNext()){
            if (iterator.next().getIndexNumber()==index){
                exists=true;
                break;
            }
            x++;
        }
        if(!exists){
            System.out.println("Error - No such index number");
            return new ArrayIterator<>(list);
        } else {
            System.arraycopy(list,0,updatedList,0,x);
            System.arraycopy(list,x+1,updatedList,x,updatedList.length-x);
            list=updatedList;
            System.out.println("Student " + index + " deleted");
            return new ArrayIterator<>(list);

        }
    }

    public ArrayIterator<Student> sort(ArrayIterator<Student> iterator){
        ArrayIterator<Student> iterator2 = iterator;
        Student student;
        boolean swapNeeded = true;

        while (iterator.hasNext() && swapNeeded) {
            swapNeeded = false;
            iterator2.first();
            while ( iterator2.hasNext()) {
                Student currentStudent = iterator2.next();
                Student nextStudent = iterator2.next();
                Student temp;
                if (currentStudent.getGrade() < nextStudent.getGrade()){
                    temp = currentStudent;

                    currentStudent.setIndexNumber(nextStudent.getIndexNumber());
                    currentStudent.setName(nextStudent.getName());
                    currentStudent.setSurname(nextStudent.getSurname());
                    currentStudent.setGrade(nextStudent.getGrade());

                    nextStudent.setIndexNumber(temp.getIndexNumber());
                    nextStudent.setName(temp.getName());
                    nextStudent.setSurname(temp.getSurname());
                    nextStudent.setGrade(temp.getGrade());

                    swapNeeded = true;
                }
            }
            if(!swapNeeded) {
                break;
            }
            iterator.next();
        }
        iterator = new ArrayIterator<>(list);
        return iterator;

        //Niestety nie działa (musiałbym dłużej nad tym pomyśleć), przepraszam ale nie mam już siły na to zadanie
    }

}
