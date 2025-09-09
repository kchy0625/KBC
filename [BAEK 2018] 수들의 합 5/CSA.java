import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public static class CSA{
    public static void main(String[] args) throws IOException {
//    초기설정
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int cnt = 1;
//    투포인터 이동으로 일치값 찾기
    int sum = 1;
    int s = 1, e = 1;
    while (e != N) {
      if (sum > N) {
        sum = sum - s;
        s++;
      } else if (sum < N) {
        e++;
        sum = sum + e;

      } else {
        e++;
        sum = sum + e;
        cnt++;
      }
    }

    System.out.println(cnt);
//  종료 설정
    br.close();
  }
}