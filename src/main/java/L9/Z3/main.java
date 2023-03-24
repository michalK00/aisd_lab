package L9.Z3;


public class main {

    public static void main(String[] args) {
        adjacencyMatrixG adjacencyMatrixG = new adjacencyMatrixG(9);

        adjacencyMatrixG.addEdge(0,1, 2);
        adjacencyMatrixG.addEdge(0,2, 1);
        adjacencyMatrixG.addEdge(0,3, 1);

        adjacencyMatrixG.addEdge(1,2, 1);
        adjacencyMatrixG.addEdge(1,4, 3);


        adjacencyMatrixG.addEdge(2,5, 1);

        adjacencyMatrixG.addEdge(3,8, 6);

        adjacencyMatrixG.addEdge(4,5, 2);
        adjacencyMatrixG.addEdge(4,6, 5);
        adjacencyMatrixG.addEdge(4,7, 2);

        adjacencyMatrixG.addEdge(5,7, 3);

        adjacencyMatrixG.addEdge(6,8, 2);
        adjacencyMatrixG.addEdge(7,8, 10);


        /*
         *           Mamy graf postaci:
         *                       0---
         *                     2/ \1 \
         *                     / 1 \  \1
         *                    1-----2  \
         *                   3|     |1  3
         *                    4-----5   |
         *                    |\ 2  |   |
         *                    | \   |   |
         *                   5| 2\  |3  |6
         *                    |   \ |   |
         *                    6     7   |
         *                     \   10\ /
         *                      ------8
         *                       2
         * */

        adjacencyMatrixG.dijkstra(0);
    }
}
