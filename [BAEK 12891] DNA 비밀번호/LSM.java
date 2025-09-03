import java.util.*;
import java.io.*;

public class Main {
    
    static int S, P;
    static char[] str;
    static Map<Character, Integer> DNA = new HashMap<>();
    static int[] minCounts = new int[4];
    static int[] counts = new int[4];
    static int safeCount = 0;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        str = br.readLine().toCharArray();
        
        DNA.put('A', 0);
        DNA.put('C', 1);
        DNA.put('G', 2);
        DNA.put('T', 3);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            minCounts[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < P; i++) {
            int index = DNA.get(str[i]);
            counts[index]++;
        }
        
        for (int i = 0; i < 4; i++) {
            if (counts[i] >= minCounts[i])
                safeCount++;
        }

        if (safeCount >= 4)
            cnt++;
        
        for(int i = 0; i < S - P; i++) {
            int left = DNA.get(str[i]);
            int right = DNA.get(str[i + P]);

            // minCount 아래로 떨어지는 순간 1번만 safeCount를 감소시킴 
            if (counts[left] == minCounts[left])
                safeCount--;
            counts[left]--;

          // minCount 이상으로 증가하는 순간 1번만 safeCount를 증가시킴
            counts[right]++;
            if (counts[right] == minCounts[right])
                safeCount++;
            
            if (safeCount == 4)
                cnt++;
        }
        
        bw.write(cnt + "");
        bw.flush();
    }
}
