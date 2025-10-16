
import java.util.*;
import java.io.*;

public class Main {
    
    public static int[][] map;
    public static int min = 30;
    public static int[] papers = { 0, 5, 5, 5, 5, 5 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        map = new int[10][10];
        
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0,0,0);
        
        if (min == 30) {
            min = -1;
        }
        
        bw.write(min + "");
        bw.flush();
        
        bw.close();
        br.close();
        
    }
    
    public static void dfs(int x, int y, int cnt) {
        
        if (x >= 9 && y >= 10) {
            min = Math.min(min, cnt);
            return;
        }
        
        if (y >= 10) {
            dfs(x+1, 0, cnt);
            return;
        }
        
        if (map[x][y] == 1) {
            for(int i = 5; i >= 1; i--) {
                if(papers[i] > 0 && isAttachable(x, y, i)) {
                    attach(x, y, i, 0);
                    papers[i]--;
                    
                    dfs(x, y+1, cnt + 1);
                    
                    papers[i]++;
                    attach(x, y, i, 1);
                }
            }
        }
        else {
            if (y+1 < 10)
                dfs(x, y+1, cnt + 1);
            else
                dfs(x+1, y, cnt + 1);
        }
        
    }
    
    public static void attach(int x, int y, int size, int state) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }
    
    public static boolean isAttachable(int x, int y, int size) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(i < 0 || i >= 10 || j < 0 || j >= 10)
                    return false;
            
                if (map[i][j] != 1)
                    return false;
            }
        }
        
        return true;
    }
}
