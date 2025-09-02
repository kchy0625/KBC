import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = 0;
		int j = 0;
		int count = Integer.MAX_VALUE;
		int sum = 0;
		
		while(i <= j && j <= N) {
			
			if(sum < S) {
				sum += arr[j++];
				
			} else if(sum >= S) {
				count = Math.min(count, j - i);
				sum -= arr[i++];
				
			}  
		}
		
		if (count == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(count);
		
	}
}
