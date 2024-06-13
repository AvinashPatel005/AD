package lab1;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void traverseBFS(Graph G,int v){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[G.getVertices()];
        q.add(v);
        visited[v]=1;
        while(!q.isEmpty()){
            int a = q.poll();
            System.out.print(a+" ");
            for (int u:G.adja[a]){
                if(visited[u]==0){
                    visited[u]=1;
                    q.add(u);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        System.out.println("Breadth First Traversal starting from vertex 0: ");
        traverseBFS(graph,0);
    }
}
