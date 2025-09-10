import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    static int N, M;
    
    static boolean isValid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
    
    public static class Point {
        int y, x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            graph[i] = br.readLine().chars()
                        .map(c -> c - '0')
                        .toArray();
        }
        
        
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (isValid(ny, nx) && graph[ny][nx] == 1) {
                    graph[ny][nx] = graph[y][x] + 1;
                    q.add(new Point(ny, nx));
                }
            }
        }

        bw.write(graph[N-1][M-1] + "");
        bw.flush();
    }
}
