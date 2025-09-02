import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int a = 0, b = 0;
        int sum = arr[0];
        int length = N + 1;
        
        while (a < N && b < N) {
            if (sum < S) {
                b++;
                if (b < N)
                    sum += arr[b];
            }
            else {
                length = Math.min(length, b - a + 1);
                sum -= arr[a];
                a++;
            }
        }
        
        if (length > N)
            bw.write("0");
        else
            bw.write(length + "");
        
        bw.flush();
    }
}
