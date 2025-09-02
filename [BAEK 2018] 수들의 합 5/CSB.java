import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int i = 1;
		int j = 1;
		int sum = 1;
		int answer = 0;
		while (j != N) {
			
			if (i == j) {
				j++;
				sum += j;
				continue;
			}
			
			
			if (sum == N) {
				answer++;
				j++;
				sum += j;
				
			} else if (sum < N) {
				j++;
				sum += j;
			} else {
				sum -= i;
				i++;
			}
			
			
			
		}
		
		System.out.println(answer + 1);

	}

}
