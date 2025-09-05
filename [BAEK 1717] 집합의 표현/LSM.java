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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new int[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (k == 0) {
                union(a, b);
            }
            else {
                if (find(a) == find(b))
                    bw.write("yes\n");
                else
                    bw.write("no\n");
            }
        }
        
        bw.flush();
    }
}

