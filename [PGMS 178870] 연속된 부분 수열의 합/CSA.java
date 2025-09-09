public class CSA {
     public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

//        초기화
        int n = sequence.length;
        int s = 0;
        int now = 0;
        int minLen = Integer.MAX_VALUE;

//        포인터 이동
        for (int e = 0; e < n; e++) {
            now += sequence[e];

//            값 찾을 때까지 반복
            while (now > k && s <= e) {
                now -= sequence[s++];
            }

//            조건 일치
            if (now == k) {
                int nowLen = e - s + 1;

                if (nowLen < minLen) {
                    minLen = nowLen;
                    answer[0] = s;
                    answer[1] = e;
                }
            }
        }

        return answer;
    }
}
