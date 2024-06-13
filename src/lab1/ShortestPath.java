package lab1;

public class ShortestPath {
    static int V = 9;
    public static int minDistance(boolean[] set,int[] dist){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for (int i = 0; i < V ; i++) {
            if(!set[i]&&dist[i]<=min){
                min=dist[i];
                min_index = i;
            }
        }
        return  min_index;
    }
    static void printSolution(int[] dist)
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void dijkstra(int[][] graph,int source){
        int[] dist = new int[V];
        boolean[] set = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i]=Integer.MAX_VALUE;
            set[i]=false;
        }
        dist[source]=0;
        for (int count = 0; count < V-1; count++) {
            int u = minDistance(set,dist);
            set[u]=true;
            for (int v = 0; v < V; v++) {
                if(!set[v]&&graph[u][v]!=0&&dist[u]!=Integer.MAX_VALUE&&(dist[u]+graph[u][v]<dist[v])){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }
        printSolution(dist);
    }
    public static void main(String[] args) {
        int graph[][] =
                { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijkstra(graph, 0);
    }
}
