package L1.z1;

public class Student {

    private String name;
    private String surname;
    private int indexNumber;
    private double grade;

    public Student() {
    }

    public Student(String name, String surname, int indexNumber, double grade) {
        this.name = name;
        this.surname = surname;
        this.indexNumber = indexNumber;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "L0.z1.Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", indexNumber=" + indexNumber +
                ", grade=" + grade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
