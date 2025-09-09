import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CSA {
     public static void main(String[] args) throws IOException {
//        입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

//        알고리즘
        int e = 0;
        int now = 0;
//        처음부터 끝까지 이동
        for (int s = 0; s < N; s++) {
//            부분합이 작고, 배열 범위 이내일 때
            while (now < S && e < N) {
                now += nums[e++];
            }
//            조건 만족했을 때 가장 짧은 길이 갱신
            if (now >= S) {
                ans = Math.min(ans, e - s);
            }
//            다음 포인터로 이동
            now -= nums[s];
        }


//        출력
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
