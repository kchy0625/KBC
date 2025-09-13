import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	static String[] arr;
	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		bfs(0, 0);
		
		System.out.println(answer);
		
		

	}
	
	static void bfs(int x, int y) {
		
		Queue<Pos> que = new LinkedList<Pos>();
		que.add(new Pos(x, y, 1));
		visited[x][y] = true;
		
		while (!que.isEmpty()) {
			Pos cur = que.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) {
				answer = cur.count;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dirX[i];
				int ny = cur.y + dirY[i];
				
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if (!visited[nx][ny] && arr[nx].charAt(ny) == '1') {
					visited[nx][ny] = true;
			
					que.add(new Pos(nx, ny, cur.count + 1));
				}
			}
			
		}
		
	}

}

class Pos {
	public int x;
	public int y;
	public int count;
	
	public Pos (int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
