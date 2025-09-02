import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int a = 1, b = 1;
        int sum = 1;
        int cnt = 0;
        
        while (a <= N && b <= N) {
            if (sum == N) {
                cnt++;
                sum -= a;    a++;
                b++;    sum += b;
            }
            else if (sum < N) {
                b++;
                sum += b;
            }
            else {
                sum -= a;
                a++;
            }
        }
        
        bw.write(cnt + "");
        bw.flush();
    }
}
