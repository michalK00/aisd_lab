package L6.z4.Hformula;

import java.util.Stack;

public class SuggestedFormula implements  HfomulaInterface{

    @Override
    public Stack<Integer> createH(int listSize) {
        Stack<Integer> hStack = new Stack<>();
        int i = 1;
        hStack.push(i);
        int h;
        while((h = 3*i + 1) <= listSize/3){
            hStack.push(h);
            i = h;
        }
        return hStack;

    }
}
