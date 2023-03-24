package L6.z2;

import java.util.Random;

public class main {

    public static void main(String[] args) throws Exception {
        CountingSort sort = new CountingSort();
        Random random = new Random();
        int n = 40;
        int min = 1;
        int max = 10;
        int[] input = new int[n];
        for(int x = 0; x<n; x++){
            input[x] = random.nextInt(max+1 - min) + min;
        }
        int[] result = sort.sort(input, min, max);
        System.out.println("INPUT:");
        printArray(input);
        System.out.println("OUTPUT:");
        printArray(result);
    }
    public static void printArray(int[] array){
        for(int x = 0; x<array.length; x++){
            System.out.print(array[x] + " ");
        }
        System.out.println();
    }
}
