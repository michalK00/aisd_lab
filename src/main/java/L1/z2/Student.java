package L1.z2;

import java.util.ArrayList;

public class Student {

    private String name;
    private String surname;
    private int indexNumber;
    private ArrayList<Double> grades;

    public Student(String name, String surname, int indexNumber, ArrayList<Double> grades) {
        this.name = name;
        this.surname = surname;
        this.indexNumber = indexNumber;
        this.grades= grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", indexNumber=" + indexNumber +
                ", grades=" + grades +
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

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public double calculateAverageGrade(){
        int temp =0;
        double average =0;
        if(grades.size()==0){
            return 0;
        }

        for(int x=0; x<grades.size();x++) {
            average+=grades.get(x);
            temp++;
        }
        return average/temp;
    }
}
