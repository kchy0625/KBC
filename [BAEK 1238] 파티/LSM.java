import java.io.*;
import java.util.*;

public class Main {
    
    public final static int INF = Integer.MAX_VALUE;
    public static int N, M, X;
    public static List<Edge>[] graph;
    public static int max = 0;
    
    public static class Edge {
        int to;
        int time;
        
        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
    
    public static class Entry implements Comparable<Entry> {
        int node;
        int time;
        
        public Entry(int node, int time) {
            this.node = node;
            this.time = time;
        }
        
        @Override
        public int compareTo(Entry o) {
            return this.time - o.time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
    
        
        graph = new ArrayList[N+1];
        
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            graph[s].add(new Edge(e, t));
        }
        
        int[] back = dijkstra(X);
        
        for(int i = 1; i < N+1; i++) {
            int[] go = dijkstra(i);
            max = Math.max(max, go[X] + back[i]);
        }
        
        bw.write(max + "");
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    public static int[] dijkstra(int s) {
        int[] times = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Entry> pq = new PriorityQueue<>();
        
        for(int i = 1; i < N+1; i++) {
            times[i] = INF;
        }
        times[s] = 0;
        
        visited[s] = true;
        pq.add(new Entry(s, 0));
        
        while(!pq.isEmpty()) {
            Entry cur = pq.poll();
            
            if (times[cur.node] < cur.time) continue;
            
            for(Edge edge : graph[cur.node]) {
                if (times[edge.to] > cur.time + edge.time)  {
                    times[edge.to] = cur.time + edge.time;
                    pq.add(new Entry(edge.to, times[edge.to]));
                }
            }
        }
        
        return times;
    }
}
