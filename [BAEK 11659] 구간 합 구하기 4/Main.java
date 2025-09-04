import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 한번만 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 줄 버퍼 단위로 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for(int i=1;i<=N;i++){
            sum[i] += sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int r=0;r<M;r++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sum[j] - sum[i-1]);
        }
    }
}
