package L9.Z3;

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
    public void dijkstra(int start){

        boolean[] visited = new boolean[numVertices];
        int[] distance = new int[numVertices];
        for (int x = 0; x < numVertices; x++){
            visited[x] = false;
            distance[x] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        for(int x = 0; x < numVertices; x++) {

            int nearestVertex = findNearestVertex(distance, visited);
            visited[nearestVertex] = true;

            for (int y = 0; y < numVertices; y++) {

                if (!visited[y] && adjMatrix[nearestVertex][y] != 0 && (distance[nearestVertex] + adjMatrix[nearestVertex][y] < distance[y]) ){
                    distance[y] = distance[nearestVertex] + adjMatrix[nearestVertex][y];
                }

            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", start, i, distance[i]));
        }

    }

    private int findNearestVertex(int[] distance, boolean[] visited) {

        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;


    }

}
