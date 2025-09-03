import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char [] DNA = {'A', 'C', 'G', 'T'};
        char[] arr = str.toCharArray();
        int[] minCount = new int[4];
        int [] currentCount = new int[4];

        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(tmp[i]);
        }

        for(int i = 0;i < P; i++){
            updateCount(currentCount, arr[i],+1);
        }
        int result = 0;

        if(check(currentCount, minCount)) result ++;

        for(int i = P;i<S;i++){
            updateCount(currentCount, arr[i], +1);
            updateCount(currentCount, arr[i-P],-1);
            if (check(currentCount, minCount)) result++;
        }
        System.out.println(result);
    }

    static void updateCount(int[] count, char c, int diff) {
        if (c == 'A') count[0] += diff;
        else if (c == 'C') count[1] += diff;
        else if (c == 'G') count[2] += diff;
        else count[3] += diff; // T
    }

    static boolean check(int[] current, int[] min) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < min[i]) return false;
        }
        return true;
    }
}
