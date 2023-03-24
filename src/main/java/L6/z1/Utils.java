package L6.z1;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

    public ArrayList<Integer> generateAlmostSortedList(int numberOfElements){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int element = 0; element<numberOfElements; element++){
            int generatedInt = (random.nextInt(2)+1)*element + (random.nextInt(10)-3);

            list.add(generatedInt);
        }
        return list;
    }
    public ArrayList<Integer> generateRandomList(int numberOfElements){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int element = 0; element<numberOfElements; element++){
            int generatedInt = random.nextInt(numberOfElements);
            list.add(generatedInt);
        }
        return list;
    }
    public void printList(ArrayList<Integer> list) {
        for(int element = 0;element<list.size();element++){
            System.out.print(list.get(element)+" ");
        }
        System.out.println();
    }
}
