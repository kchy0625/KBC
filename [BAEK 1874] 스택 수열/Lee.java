import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int x = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            int next = Integer.parseInt(br.readLine());
            
            while (x <= next) {
                stack.push(x++);
                sb.append("+\n");
            }
            
            if (!stack.isEmpty() && next == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                bw.write("NO\n");
                bw.flush();
                return;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
