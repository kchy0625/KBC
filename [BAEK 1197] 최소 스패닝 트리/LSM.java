import java.util.*;
import java.io.*;

public class Main {
    
    static int[] graph;
    
    static int find(int i) {
        if (graph[i] != i)
            graph[i] = find(graph[i]);
        
        return graph[i];
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        
        graph[b] = a;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        graph = new int[V + 1];
        for(int i = 1; i <= V; i++)
            graph[i] = i;
        
        
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(A, B, C));
        }
        
        Collections.sort(edges);
        
        int cost = 0;
        
        for(Edge edge : edges) {
            if (find(edge.A) == find(edge.B))
                continue;
            
            union(edge.A, edge.B);
            cost += edge.C;
        }
        
        bw.write(cost + "");
        bw.flush();
    }
    
    public static class Edge implements Comparable<Edge> {
        int A, B, C;
        
        public Edge(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.C, other.C);
            // return this.C - other.C;
        }
    }
}
