import java.util.*;
import java.io.*;

    public class Main {
        static int ans = 0;
        static int N;
        static boolean[] v1; 
        static boolean[] v2; 
        static boolean[] v3; 

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());

            v1 = new boolean[N];
            v2 = new boolean[2 * N];
            v3 = new boolean[2 * N];

            dfs(0);

            System.out.println(ans);
        }

        public static void dfs(int n) {
            if (n == N) {
                ans++;
                return;
            }

            for (int j = 0; j < N; j++) {

                if (!v1[j] && !v2[n + j] && !v3[n - j + N]) {
                    v1[j] = true;
                    v2[n + j] = true;
                    v3[n - j + N] = true;

                    dfs(n + 1);

                    v1[j] = false;
                    v2[n + j] = false;
                    v3[n - j + N] = false;
                }
            }
        }
    }
