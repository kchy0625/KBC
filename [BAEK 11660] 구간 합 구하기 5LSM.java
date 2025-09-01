import java.util.*;
import java.io.*;

public class Main {
    
    static String[] input;
    static int N, M, x1, y1, x2, y2;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        arr = new int[N+1][N+1];
        
        for(int i = 1; i <= N; i++) {  
            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]) + arr[i][j-1];
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] += arr[i-1][j];
            }
        }

        bw.flush();
        
        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            x1 = Integer.parseInt(input[0]);    y1 = Integer.parseInt(input[1]);
            x2 = Integer.parseInt(input[2]);    y2 = Integer.parseInt(input[3]);
            
            int sum = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1];
            bw.write(sum + "\n");
        }
        
        bw.flush();
    }
}
