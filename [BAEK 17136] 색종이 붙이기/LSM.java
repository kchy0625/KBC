import java.util.*;
import java.io.*;

public class Main {
    
    public static int[][] map = new int[10][10];
    public static int min = Integer.MAX_VALUE;
    public static int[] papers = { 0, 5, 5, 5, 5, 5 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        
        if (min == Integer.MAX_VALUE)
            min = -1;
        
        bw.write(min + "");
        bw.flush();
        
        bw.close();
        br.close();
        
    }
    
    public static void dfs(int xy, int cnt) {
        
        if (xy >= 100) {
            min = Math.min(cnt, min);
            return;
        }
        
        int x = xy / 10;
        int y = xy % 10;
        
        if (map[x][y] == 1) {
            for(int i = 5; i >= 1; i--) {
                if(papers[i] > 0 && isAttachable(x, y, i)) {
                    attach(x, y, i, 0);
                    papers[i]--;
                    
                    dfs(xy + 1, cnt + 1);
                    
                    papers[i]++;
                    attach(x, y, i, 1);
                }
            }
        }
        else {
            dfs(xy + 1, cnt);
        }
        
    }
    
    public static boolean isAttachable(int x, int y, int size) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                
                if (i < 0 || i >= 10 || j < 0 || j >= 10)
                    return false;
                
                if (map[i][j] == 0)
                    return false;
            }
        }
        
        return true;
    }
    
    public static void attach(int x, int y, int size, int state) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }
}
