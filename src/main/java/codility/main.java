package codility;

import static org.junit.Assert.assertEquals;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int X[] = {8,10,11,13,100};
        int A[] = {4,1,4,3,3};


        int result = solution.solution(X, A);
        int expected = 4;
        assertEquals(expected, result);

    }

}
