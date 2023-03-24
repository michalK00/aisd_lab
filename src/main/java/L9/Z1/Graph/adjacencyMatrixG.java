package L9.Z1.Graph;

import java.util.Arrays;

public class adjacencyMatrixG {

    private int adjMatrix[][];
    private int numVertices;

    public adjacencyMatrixG(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addVertex(){
        int[][] adjMatrix2 = new int[numVertices+1][numVertices+1];
        copyMatrix(adjMatrix2);
        adjMatrix = adjMatrix2;
        numVertices++;
    }


    public void addEdge(int i, int j, int weight) {
        if(i == j){
            System.out.println("Cant add edge to itself");
            return;
        }
        if(weight<=0){
            System.out.println("Weight can't be lower than 1");
            return;
        }
        if(adjMatrix[i][j] != 0){
            System.out.println("Edge already exists");
            return;
        }
        adjMatrix[i][j] = weight;
        adjMatrix[j][i] = weight;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : adjMatrix[i]) {
                s.append(j + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    private void copyMatrix(int[][] adjMatrix2){
        for(int x = 0; x<adjMatrix.length; x++){
            for(int y = 0; y<adjMatrix[x].length; y++){
                adjMatrix2[x][y] = adjMatrix[x][y];
            }
        }
    }
    public void Prim(){
        int INF = Integer.MAX_VALUE;

        int no_edge = 0; // number of edge

        boolean[] selected = new boolean[numVertices];

        for(int x = 0; x < selected.length; x++){
            selected[x] = false;
        }

        selected[0] = true;
        System.out.println("Edge : Weight");

        while (no_edge < numVertices - 1) {

            int min = INF;
            int x = 0; // row number
            int y = 0; // col number

            for (int i = 0; i < numVertices; i++) {
                if (selected[i]) {
                    for (int j = 0; j < numVertices; j++) {
                        // not in selected and there is an edge
                        if (!selected[j] && adjMatrix[i][j] != 0) {
                            if (min > adjMatrix[i][j]) {
                                min = adjMatrix[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + adjMatrix[x][y]);
            selected[y] = true;
            no_edge++;
        }
    }

}
