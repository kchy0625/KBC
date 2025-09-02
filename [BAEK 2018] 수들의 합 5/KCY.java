import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int arr [] = new int[N];
        for (int i = 0; i< N; i++){
            arr[i] = i+1;
        }
        int cnt = 0;
        int intervalSum = 0;
        int end = 0;

        for(int start = 0; start < N; start++){
            while(intervalSum < N && end < N ){
                intervalSum += arr[end];
                end++;
            }
            if (intervalSum == N){
                cnt++;
            }
            intervalSum -= arr[start];
        }
        System.out.println(cnt);
    }
}
