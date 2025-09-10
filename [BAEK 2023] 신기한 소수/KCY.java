import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);


    }

    public static void dfs(int number, int digit){
        if(digit == N) {
            System.out.println(number);
            return;
        }
        for(int i = 1;i<=9;i+=2) {
            int next = number * 10+i;
            if(isPrime(next)) {
                dfs(next,digit+1);
            }
        }
    }


    public static boolean isPrime(int n){
        if(n < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
