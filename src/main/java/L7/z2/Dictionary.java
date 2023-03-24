package L7.z2;

import L7.z2.Comparators.ComparatorInterace;

public class Dictionary {

    private Student tab[];
    private ComparatorInterace<Student> comp;
    private int size;

    public Dictionary(ComparatorInterace<Student> comp, int initialSize){
        this.comp = comp;
        tab = new Student[(int) (2*initialSize)];
        size = 0;
    }

    public int indexOf(Student s){
        int leftIndex = 0;
        int rightIndex = tab.length;
        int middleIndex;
        while(leftIndex <= rightIndex){
            middleIndex=(leftIndex + rightIndex) / 2;
            if(tab[middleIndex] == null){
                rightIndex = middleIndex - 1;
            } else {
                int compValue = comp.compare(s, tab[middleIndex]);
                if (compValue == 0)
                    return middleIndex;
                if (compValue < 0)
                    rightIndex = middleIndex - 1;
                else
                    leftIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public void add(Student s){

        if(tab[0] == null){
            tab[0] = s;
            size++;
            return;
        }

        size++;
        arrayOverfillFix();

        int x = 0;
        while(tab[x] != null){
            if(comp.compare(s, tab[x]) < 0){
                moveEverythingByOneAndInsertAtX(s,x);
                return;
            }
            x++;
        }

        tab[x] = s;
    }

    public void viewDictionary(){
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] == null)
                return;
            System.out.println(tab[i]);
        }
    }

    public boolean contains(Student s){
        if(indexOf(s) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public Student[] getTab() {
        return tab;
    }

    private void arrayOverfillFix(){
        if(size >= 0.8 * tab.length){
            Student[] temp = new Student[2*tab.length];
            System.arraycopy(tab,0,temp,0,size-1);
            tab = temp;
        }
    }
    private void moveEverythingByOneAndInsertAtX(Student s, int x){
        Student element = tab[x];
        Student nextElement = tab[x+1];

        tab[x] = s;
        while(nextElement != null) {
            tab[x + 1] = element;
            element = nextElement;
            nextElement = tab[x + 2];
            x++;
        }
        tab[x+1] = element;
    }

}
