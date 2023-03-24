package L6.z3;

public class Student{
    private int index;
    private double grade;

    public Student(int index, double grade) {

        this.index = index;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                ", grade=" + grade +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
