import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CSA {
  public static void main(String[] args) throws IOException {
//    초기 설정
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N + 1][N + 1];     // 1-based index
    int[][] sumArr = new int[N + 1][N + 1];  // 누적합 배열

//    배열입력 및 누적합 계산
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + arr[i][j];
      }
    }

    // 질의 처리
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int result =
          sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];

      System.out.println(result);
    }

//    종료 설정
    br.close();
  }
}
