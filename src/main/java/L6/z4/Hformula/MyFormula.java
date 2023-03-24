package L6.z4.Hformula;

import java.util.Stack;

public class MyFormula implements HfomulaInterface{

    @Override
    public Stack<Integer> createH(int listSize) {
        Stack<Integer> hStack = new Stack<>();
        int k = 1;
        int h;
        while((h = (int) (Math.pow(2, k) - 1)) <= listSize/3){
            hStack.push(h);
            k++;
        }
        return hStack;
    }

}
