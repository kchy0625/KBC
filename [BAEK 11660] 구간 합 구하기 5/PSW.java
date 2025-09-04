import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] sums = new long[N + 1][N+1];

        for(int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for(int y = 1; y <= N; y++) {
                sums[x][y] = sums[x][y-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int repeat = 0; repeat<M; repeat++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum=0;
            for(int x=x1; x<=x2; x++){
                sum += sums[x][y2] - sums[x][y1-1];
            }
            System.out.println(sum);
        }
    }
}
