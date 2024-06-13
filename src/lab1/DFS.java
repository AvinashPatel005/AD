package lab1;
import java.util.Stack;

public class DFS {
    public static void traverseBFS(Graph G,int v){
        Stack<Integer> s = new Stack<>();
        int[] visited = new int[G.getVertices()];
        s.add(v);
        visited[v]=1;
        while(!s.isEmpty()){
            int a = s.pop();
            System.out.print(a+" ");
            for (int u:G.adja[a]){
                if(visited[u]==0){
                    visited[u]=1;
                    s.add(u);
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
        System.out.println("Depth First Traversal starting from vertex 0: ");
        traverseBFS(graph,0);
    }
}
