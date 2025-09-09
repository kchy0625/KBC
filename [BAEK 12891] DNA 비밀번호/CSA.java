import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CSA {
    public static void main(String[] args) throws IOException {
//    입력 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] dnas = br.readLine().toCharArray(); // 문자열 한 줄 → 문자 배열
		
		int[] acgt = new int[4]; // A, C, G, T 순서
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] myAcgt = {0, 0, 0, 0};
		int cnt = 0;
//		초기 슬라이딩 윈도우 구성
		for (int i = 0; i < P; i++) {
			char alpha = dnas[i];
			add(myAcgt, alpha);
		}
		
		//			acgt 조건을 모두 맞췄는지 확인
		if (check(myAcgt, acgt)) {
			cnt++;
		}

//		슬라이딩 윈도우
		for (int i = P; i < S; i++) {
			// 들어오는 문자
			add(myAcgt, dnas[i]);
			// 빠지는 문자
			minus(myAcgt, dnas[i - P]);
			//			acgt 조건을 모두 맞췄는지 확인
			if (check(myAcgt, acgt)) {
				cnt++;
			}
		}
		System.out.println(cnt);

//    종료 설정
		br.close();
	}
	
	static void add(int[] myAcgt, char c) {
		switch (c) {
			case 'A':
				myAcgt[0]++;
				break;
			case 'C':
				myAcgt[1]++;
				break;
			case 'G':
				myAcgt[2]++;
				break;
			case 'T':
				myAcgt[3]++;
				break;
		}
	}
	
	static void minus(int[] myAcgt, char c) {
		switch (c) {
			case 'A':
				myAcgt[0]--;
				break;
			case 'C':
				myAcgt[1]--;
				break;
			case 'G':
				myAcgt[2]--;
				break;
			case 'T':
				myAcgt[3]--;
				break;
		}
	}
	
	static boolean check(int[] myAcgt, int[] acgt) {
		for (int i = 0; i < 4; i++) {
			if (myAcgt[i] < acgt[i]) {
				return false;
			}
		}
		return true;
	}
	
    
}
