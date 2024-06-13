package lab1;

import java.util.LinkedList;

public class Graph {
    int vertices;
    LinkedList<Integer>[] adja;
    Graph(int vertices){
        this.vertices=vertices;
        adja = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adja[i] = new LinkedList<>();
        }
    }
    public void addEdge(int u,int v){
        adja[u].add(v);
    }
    public int getVertices(){
        return vertices;
    }
}
