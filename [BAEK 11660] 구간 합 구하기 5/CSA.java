import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CSA {

  public static void main(String[] args) throws IOException {
//    초기 세팅
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    데이터의 개수, 줄의 개수
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

//    구간합을 구할 대상 배열
    String[] line = br.readLine().split(" ");
    int[] arr = new int[N];
    int[] sumArr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(line[i]);
//      첫번째 인덱스는 바로 저장
      if (i == 0) {
        sumArr[i] = arr[i];
      } else {
        sumArr[i] = sumArr[i - 1] + arr[i];
      }
    }

//    각 라인을 돌면서 계산 후 출력
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken()) - 1;
      int e = Integer.parseInt(st.nextToken()) - 1;

      if (s == 0) {
        System.out.println(sumArr[e]);
      } else {
        System.out.println(sumArr[e] - sumArr[s - 1]);
      }
    }

//    종료 옵션
    br.close();
  }

}

