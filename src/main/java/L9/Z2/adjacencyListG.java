package L9.Z2;

import java.text.DateFormatSymbols;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class adjacencyListG {

    private int numVertices;
    private ArrayList<Edge>[] adjList;

    public adjacencyListG(int numVertices) {
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
        adjList[secondVertex].add(new Edge(firstVertex, weight));

    }

    private void copyTab(ArrayList<Edge>[] adjList2){
        for(int x = 0; x<numVertices+1; x++){
            adjList2[x] = new ArrayList<>();
        }
        for(int x = 0; x<adjList.length; x++){
            adjList2[x] = adjList[x];
        }
    }

    public void BFS(int start){

        boolean[] visited = new boolean[numVertices];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0){

            start = queue.poll();
            System.out.println(start + " ");
            Iterator<Edge> iterator = adjList[start].iterator();

            while(iterator.hasNext()){
                int n = iterator.next().secondVertex;
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }

    }
    public void DFS(int start){
        boolean[] visited = new boolean[numVertices];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        DFSalg(start, visited, stack);
    }

    private void DFSalg(int start, boolean[] visited, ArrayDeque<Integer> stack){
        visited[start] = true;
        stack.push(start);
        System.out.println(start + " ");

        while(stack.size() != 0){

            start = stack.pop();

            Iterator<Edge> iterator = adjList[start].iterator();

            while(iterator.hasNext()){
                int n = iterator.next().secondVertex;
                if(!visited[n]){
                    DFSalg(n, visited, stack);
                }
            }

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
