package L9.Z1.Digraph;



import java.util.ArrayList;

public class adjacencyListD {

    private int numVertices;
    private ArrayList<Edge>[] adjList;

    public adjacencyListD(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList[numVertices];
        for(int x = 0; x<numVertices; x++){
            adjList[x] = new ArrayList<>();
        }
    }

    public void addVertex(){

        ArrayList<Edge>[] adjList2 = new ArrayList[numVertices+1];
        copyTab(adjList2);
        adjList = adjList2;
        numVertices++;
    }
    public void addEdge(int firstVertex, int secondVertex, int weight){
        if(firstVertex == secondVertex){
            System.out.println("Cant add edge to itself");
            return;
        }
        if(weight<=0){
            System.out.println("Weight can't be lower than 1");
            return;
        }
        if(adjList[firstVertex] != null){
            for(int x = 0; x<adjList[firstVertex].size(); x++){
                if(adjList[firstVertex].get(x).secondVertex == secondVertex){
                    System.out.println("Edge already exists");
                    return;
                }
            }
        }
        adjList[firstVertex].add(new Edge(secondVertex, weight));

    }

    private void copyTab(ArrayList<Edge>[] adjList2){
        for(int x = 0; x<numVertices+1; x++){
            adjList2[x] = new ArrayList<>();
        }
        for(int x = 0; x<adjList.length; x++){
            adjList2[x] = adjList[x];
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < adjList.length; i++) {
            s.append(i + ": ");
            if(adjList[i] != null){
                for (Edge j : adjList[i]) {
                    s.append(j + " ");
                }
                s.append("\n");
            }
        }
        return s.toString();
    }

    private class Edge{
        private int secondVertex;
        private int value;

        public Edge(int secondVertex, int value) {
            this.secondVertex = secondVertex;
            this.value = value;
        }

        public int getSecondVertex() {
            return secondVertex;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "secondVertex=" + secondVertex +
                    ", value=" + value +
                    '}';
        }
    }

}
