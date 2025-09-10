import java.util.*;
import java.io.*;

public class Main {
    
    static int[] graph;
    
    static int find(int x) {
        if (graph[x] != x)
            graph[x] = find(graph[x]);
        
        return graph[x];
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        graph[b] = a;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        graph = new int[N+1];
        for(int i = 1; i <= N; i++)
            graph[i] = i;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            union(a, b);
        }
        
        int cnt = 0;
        
        for (int i = 1; i <= N; i++)
            if (graph[i] == i)
                cnt++;

        bw.write(cnt + "");
        bw.flush();
        
        bw.close();
        br.close();
    }
}
