import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[] files;
    static boolean[] diag1;
    static boolean[] diag2;
        
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        files = new boolean[N];
        diag1 = new boolean[N * 2 - 1];
        diag2 = new boolean[N * 2 - 1];
        
        dfs(N, 0);
        
        bw.write(cnt + "");
        bw.flush();
    }
    
    static void dfs(int N, int rank) {
        
        if (rank == N) {
            cnt++;
            return;   
        }
        
        for(int i = 0; i < N; i++) {
            if (files[i])
                continue;
            
            if (diag1[i + rank])
                continue;
            
            if (diag2[i - rank + N - 1])
                continue;
            
            files[i] = true;
            diag1[i + rank] = true;
            diag2[i - rank + N - 1] = true;
            
            dfs(N, rank + 1);
            
            files[i] = false;
            diag1[i + rank] = false;
            diag2[i - rank + N - 1] = false;
        }
    }
}
