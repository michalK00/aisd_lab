package L7.z2;

public class Student {
    private String name, surname;
    private int index;

    public Student(String name, String surname, int index) {
        this.name = name;
        this.surname = surname;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", index=" + index +
                '}';
    }



    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
