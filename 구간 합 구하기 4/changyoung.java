import java.util.*;
import java.io.*;

public class changyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int numbers [] = new int[N+1];
        int sum_list[] = new int[N+1];

        for(int i = 1; i<= N;i++){
            numbers[i] = sc.nextInt();
            sum_list[i] = sum_list[i-1] + numbers[i];

        }
        for(int i = 0; i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(sum_list[b] - sum_list[a - 1]);
            }
        }
    }
