package L9.Z1.Graph;

public class incidenceMatrixG {

    private int incMatrix[][];
    private int numVertices;
    private int numberOfEdges;

    public incidenceMatrixG(int numVertices) {
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
        incMatrix[j][numberOfEdges] = weight;
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
                s.append(j + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }



    public void Prim(){
        int INF = Integer.MAX_VALUE;

        int no_edge = 0; // number of edge

        boolean[] selected = new boolean[numVertices];
        boolean[] used = new boolean[numVertices];

        for(int x = 0; x < selected.length; x++){
            selected[x] = false;
            used[x] = false;
        }
        selected[0] = true;

        System.out.println("Edge : Weight");
        while (no_edge < numVertices - 1) {

            int min = INF;
            int z = -1; //second vertex number
            int x = 0; // row number
            int y = 0; // col number
            for(int i = 0; i < numVertices; i++){

                if(selected[i]){

                    for(int j = 0; j < numberOfEdges; j++){

                        if(incMatrix[i][j] != 0){

                            if (min > incMatrix[i][j]) {

                                min = incMatrix[i][j];
                                x = i;
                                y = j;

                            }
                        }
                    }
                    for(int k = 0; k<numVertices; k++){
                        if(incMatrix[k][y] != 0 && k != i){
                            z = k;
                        }
                    }
                    if(z == -1){

                    }

                }
            }
            if(z != -1){
                selected[z] = true;
                System.out.println(x + " - " + z + " :  " + incMatrix[x][y]);
                no_edge++;
            }




        }
    }
//    for (int i = 0; i < numVertices; i++) {
//        if (available[i]) {
//            for (int j = 0; j < numberOfEdges; j++) {
//
//                // index out of bound będzie ponieważ numberOfEdges może być znacznie większy niż numVertices
//                // not in selected and there is an edge
//                if (!available[j] && incMatrix[i][j] != 0 && j != i) {
//                    if (min > incMatrix[i][j]) {
//                        min = incMatrix[i][j];
//                        x = i;
//                        y = j;
//                    }
//
//
//                }
//            }
//        }
//    }
//    int z = -1;
//            for(int a = 0; a<numVertices; a++){
//        if((incMatrix[a][y] != 0) && (a != x)){
//            available[a] = true;
//            z = a;
//        }
//    }
//            System.out.println(x + " - " + z + " :  " + incMatrix[x][y]);
//    no_edge++;
}
