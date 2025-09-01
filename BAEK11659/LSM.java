import java.util.*;
import java.io.*;

public class Main {

    static String[] inputLine;
    static int N, M, a, b;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        inputLine = br.readLine().split(" ");
        N = Integer.parseInt(inputLine[0]);
        M = Integer.parseInt(inputLine[1]);
        
        int[] arr = new int[N+1];
        
        inputLine = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(inputLine[i-1]) + arr[i-1];
        }
        
        for(int i = 0; i < M; i++) {
            inputLine = br.readLine().split(" ");
            a = Integer.parseInt(inputLine[0]);
            b = Integer.parseInt(inputLine[1]);
            
            bw.write((arr[b] - arr[a-1]) + "\n");
        }
        
        bw.flush();
    }
}
