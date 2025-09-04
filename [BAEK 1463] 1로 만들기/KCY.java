import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int dp [] = new int[1000001];

        for(int i = 2;i<X+1;i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }

        }
        System.out.println(dp[X]);
    }
}
