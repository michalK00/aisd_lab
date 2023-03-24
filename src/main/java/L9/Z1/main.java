package L9.Z1;


import L9.Z1.Digraph.adjacencyListD;
import L9.Z1.Digraph.adjacencyMatrixD;
import L9.Z1.Digraph.incidenceMatrixD;
import L9.Z1.Graph.adjacencyListG;
import L9.Z1.Graph.adjacencyMatrixG;
import L9.Z1.Graph.incidenceMatrixG;

public class main {

    public static void main(String[] args) {

        System.out.println("\nAdjacency Matrix Graph");

        adjacencyMatrixG adjacencyMatrixG = new adjacencyMatrixG(4);

        adjacencyMatrixG.addEdge(1,3, 4);
        adjacencyMatrixG.addEdge(2,3, 2);
        adjacencyMatrixG.addEdge(3,0, 1);
        adjacencyMatrixG.addEdge(2,1, 3);

        System.out.println(adjacencyMatrixG);

        adjacencyMatrixG.addVertex();
        adjacencyMatrixG.addEdge(4,2, 1);
        System.out.println(adjacencyMatrixG);

        adjacencyMatrixG.Prim();

        //####################################################################

        System.out.println("\nAdjacency List Graph");

        adjacencyListG adjacencyListG = new adjacencyListG(4);


        adjacencyListG.addEdge(1,3, 4);
        adjacencyListG.addEdge(2,3, 2);
        adjacencyListG.addEdge(3,0, 1);
        adjacencyListG.addEdge(2,1, 3);

        System.out.println(adjacencyListG);

        adjacencyListG.addVertex();
        adjacencyListG.addEdge(4,2, 1);
        System.out.println(adjacencyListG);


        adjacencyMatrixG.Prim();

        //####################################################################

        System.out.println("\nIncidence Matrix Graph");

        incidenceMatrixG incidenceMatrixG = new incidenceMatrixG(4);


        incidenceMatrixG.addEdge(1,3, 4);
        incidenceMatrixG.addEdge(2,3, 2);
        incidenceMatrixG.addEdge(3,0, 1);
        incidenceMatrixG.addEdge(2,1, 3);

        System.out.println(incidenceMatrixG);

        incidenceMatrixG.addVertex();
        incidenceMatrixG.addEdge(4,2, 1);
        System.out.println(incidenceMatrixG);


        adjacencyMatrixG.Prim();

        //####################################################################

        System.out.println("\nAdjacency Matrix Digraph");

        adjacencyMatrixD adjacencyMatrixD = new adjacencyMatrixD(4);


        adjacencyMatrixD.addEdge(1,3, 4);
        adjacencyMatrixD.addEdge(2,3, 2);
        adjacencyMatrixD.addEdge(3,0, 1);
        adjacencyMatrixD.addEdge(2,1, 3);

        System.out.println(adjacencyMatrixD);

        adjacencyMatrixD.addVertex();
        adjacencyMatrixD.addEdge(4,2, 1);
        System.out.println(adjacencyMatrixD);

        //####################################################################

        System.out.println("\nAdjacency List Digraph");

        adjacencyListD adjacencyListD = new adjacencyListD(4);


        adjacencyListD.addEdge(1,3, 4);
        adjacencyListD.addEdge(2,3, 2);
        adjacencyListD.addEdge(3,0, 1);
        adjacencyListD.addEdge(2,1, 3);

        System.out.println(adjacencyListD);

        adjacencyListD.addVertex();
        adjacencyListD.addEdge(4,2, 1);
        System.out.println(adjacencyListD);

        //####################################################################

        System.out.println("\nIncidence Matrix Digraph");

        incidenceMatrixD incidenceMatrixD = new incidenceMatrixD(4);


        incidenceMatrixD.addEdge(1,3, 4);
        incidenceMatrixD.addEdge(2,3, 2);
        incidenceMatrixD.addEdge(3,0, 1);
        incidenceMatrixD.addEdge(2,1, 3);

        System.out.println(incidenceMatrixD);

        incidenceMatrixD.addVertex();
        incidenceMatrixD.addEdge(4,2, 1);
        System.out.println(incidenceMatrixD);


    }
}
