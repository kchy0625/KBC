import java.util.*;
import java.io.*;

public class Main {
    
    static boolean isPrime(int num) {

        if (num <= 1)
            return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        int min = (int)Math.pow(10, N-1);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 1; i <= 10; i++) {
                int next = cur * 10 + i;
                
                if(isPrime(next)) {
                    if(next >= min) {
                        bw.write(next + "\n");
                    }
                    else {
                        q.add(next);
                    }
                }
            }
        }
    
        bw.flush();

    }
}
