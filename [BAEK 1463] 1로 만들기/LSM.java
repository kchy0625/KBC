import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur % 3 == 0 && dp[cur / 3] == 0) {
                dp[cur / 3] = dp[cur] + 1;
                q.add(cur / 3);   
            }
            
            if (cur % 2 == 0 && dp[cur / 2] == 0) {
                dp[cur / 2] = dp[cur] + 1;
                q.add(cur / 2);
            }
            
            if (cur - 1 > 0 && dp[cur - 1] == 0) {
                dp[cur - 1] = dp[cur] + 1;
                q.add(cur - 1);
            }
        }
        
        bw.write(dp[1] + "");
        bw.flush();
        
    }
}
