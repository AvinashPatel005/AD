package lab1;

public class MST {
    static int INF = Integer.MAX_VALUE;
    int[][] graph;
    int vertices;
    int[] parent;
    MST(int[][] arr){
        graph = arr;
        vertices = arr.length;
        parent = new int[arr.length];
    }
    public int findMST(){
        int cost = 0;
        int edge_count = 0;
        for (int i = 0; i < vertices; i++)
            parent[i] = i;
        while (edge_count<vertices-1){
            int min = INF;
            int a=-1;
            int b=-1;
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices ; j++) {
                    if(find(i)!=find(j)&&graph[i][j]<min){
                        min = graph[i][j];
                        a=i;
                        b=j;
                    }
                }
            }

            union(a,b);
            edge_count++;
            System.out.println(edge_count+"-("+a+","+b+") : "+graph[a][b]);
            cost+=min;
        }
        return cost;
    }
    public int find(int i){
       if(parent[i]==i) return i;
       return find(parent[i]);
    }
    public void union(int i,int j){
        int a = find(i);
        int b = find(j);
        parent[a]=b;
    }
    public static void main(String[] args) {
        int[][]  graph= {
                { INF, 2, INF, 6, INF },
                { 2, INF, 3, 8, 5 },
                { INF, 3, INF, INF, 7 },
                { 6, 8, INF, INF, 9 },
                { INF, 5, 7, 9, INF },
        };
        MST mst = new MST(graph);
        System.out.println(mst.findMST());
    }
}
