package L7.z3;


import L7.z3.Comparators.ComparatorInterace;

public class HashDictionary {

    private Student tab[];
    private ComparatorInterace<Student> comp;
    private int size;

    public HashDictionary(ComparatorInterace<Student> comp, int initialSize){
        this.comp = comp;
        tab = new Student[(int) (2*initialSize)];
        size = 0;
    }

    public int indexOf(Student s){
        int position = Math.abs(s.hashCode() % tab.length);
        int i = 1;
        while(tab[position] != null){
            if(comp.compare(s, tab[position]) == 0){
                return position;
            } else {
                position = (int) Math.abs((position + (Math.pow(-1, i-1) * Math.pow((i+1) / 2, 2))) % tab.length);
                i++;
            }
        }
        return -1;
    }

    public void add(Student s){
        size++;
        arrayOverfillFix();
        hashFunctionAdding(s, tab);
    }

    public void viewDictionary(){
        for (int i = 0; i < tab.length; i++) {
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


    private void hashFunctionAdding(Student s, Student[] tab){
        int position = Math.abs(s.hashCode() % tab.length);
        int i = 1;
        while(tab[position] != null){
            position = (int) Math.abs((position + (Math.pow(-1, i-1) * Math.pow((i+1) / 2, 2))) % tab.length);
            i++;
        }
        if(tab[position] != null)
            throw new UnknownError();
        tab[position] = s;
    }

    private void arrayOverfillFix(){
        if(size >= 0.8 * tab.length){
            Student[] temp = new Student[2 * tab.length];
            for (int i = 0; i < tab.length; i++) {
                if(tab[i] != null)
                    hashFunctionAdding(tab[i], temp);
            }
            tab = temp;
        }
    }
}
