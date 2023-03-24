package L9.Z1.Digraph;

public class adjacencyMatrixD {

    private int adjMatrix[][];
    private int numVertices;

    public adjacencyMatrixD(int numVertices) {
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

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("X: ");
        for (int i = 0; i < numVertices; i++) {
            s.append(i + " ");
        }
        s.append("\n");
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


}
