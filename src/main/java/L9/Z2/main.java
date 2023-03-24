package L9.Z2;



public class main {

    public static void main(String[] args) {


        System.out.println("\nAdjacency List Graph");

        adjacencyListG adjacencyListG = new adjacencyListG(7);


        adjacencyListG.addEdge(0,1, 4);
        adjacencyListG.addEdge(0,2, 2);

        adjacencyListG.addEdge(1,3, 1);
        adjacencyListG.addEdge(1,4, 3);

        adjacencyListG.addEdge(2,5, 2);
        adjacencyListG.addEdge(2,6, 2);
        /*
        *           Mamy drzewo/graf postaci:
        *                       0
        *                      / \
        *                     /   \
        *                    1     2
        *                   / \   / \
        *                  3   4 5   6
        *
        * BFS powinien dać wynik:
        * 0,1,2,3,4,5,6
        * DFS powinien dać wynik:
        * 0,1,3,4,2,5,6
        * */

        System.out.println(adjacencyListG);


        System.out.println("BFS:");
        adjacencyListG.BFS(0);
        System.out.println("DFS:");
        adjacencyListG.DFS(0);

    }

}
