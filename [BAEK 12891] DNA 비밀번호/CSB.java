import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] required = new int[4];
	static int state = 0;
	static char[] arr;
	static int[] cur = new int[4];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		arr = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			required[i] = Integer.parseInt(st.nextToken());
			if (required[i] == 0) state++;
		}
		
		for (int i = 0; i < P; i++) {
			add(arr[i]);	
		}
		
		
		int answer = 0;
		if (state == 4) {
			answer++;
		}
		
		for (int i = P; i < S; i++) {
			remove(arr[i - P]);
			add(arr[i]);
			
			
			if (state == 4) answer++;
		}
		
		System.out.println(answer);
		
		
		
		
		
		
		

	}
	
	public static void add(char c) {
		
		switch (c) {
			case 'A':
				cur[0]++;
				if (cur[0] == required[0]) state++;
				break;
			case 'C':
				cur[1]++;
				if (cur[1] == required[1]) state++;
				break;
			case 'G':
				cur[2]++;
				if (cur[2] == required[2]) state++;
				break;
			case 'T':
				cur[3]++;
				if (cur[3] == required[3]) state++;
				break;
		}
		
		
	}
	
	public static void remove(char c) {
		
		
		switch (c) {
			case 'A':
				if (cur[0] == required[0]) state--;
				cur[0]--;
				break;
			case 'C':
				if (cur[1] == required[1]) state--;
				cur[1]--;
				break;
			case 'G':
				if (cur[2] == required[2]) state--;
				cur[2]--;
				break;
			case 'T':
				if (cur[3] == required[3]) state--;
				cur[3]--;
				break;
				
		}
		
	}
	
	

}
