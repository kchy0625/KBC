import java.io.*;
import java.util.*;

public  class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] stack = new int[N];
        int top = -1;
        int current = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            while(current <= num){
                stack[++top] = current++;
                sb.append("+\n");
            }
            if (stack[top] == num){
                top --;
                sb.append("-\n");
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}