package L9.Z1.Digraph;

public class incidenceMatrixD {

    private int incMatrix[][];
    private int numVertices;
    private int numberOfEdges;

    public incidenceMatrixD(int numVertices) {
        this.numVertices = numVertices;
        numberOfEdges = 0;
        incMatrix = new int[numVertices][numberOfEdges];
    }
    public void addVertex(){
        int[][] incMatrix2 = new int[numVertices+1][incMatrix[numVertices-1].length];
        copyMatrix(incMatrix2);
        incMatrix = incMatrix2;
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
        int[][] incMatrix2 = new int[numVertices][numberOfEdges+1];
        copyMatrix(incMatrix2);
        incMatrix = incMatrix2;
        incMatrix[i][numberOfEdges] = weight;
        incMatrix[j][numberOfEdges] = -weight;
        numberOfEdges++;

    }


    private void copyMatrix(int[][] incMatrix2){
        for(int x = 0; x<incMatrix.length; x++){
            for(int y = 0; y<incMatrix[x].length; y++){
                incMatrix2[x][y] = incMatrix[x][y];
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : incMatrix[i]) {
                if(j < 0){
                    s.append(j + "  ");
                } else
                    s.append(j + "   ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
