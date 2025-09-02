import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr [] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (true){
            if(sum >= M){
                minLen = Math.min(minLen,end-start);
                sum -= arr[start++];
            }else if(end == N){
                break;

            }else{
                sum += arr[end++];
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }

    }
}
