import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				answer++;
				bfs(i);
			}
		}
		
		System.out.println(answer);

	}
	
	static void bfs(int node) {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(node);
		visited[node] = true;
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			
			for (int i = 0; i < adjList[cur].size(); i++) {
				
				int next = adjList[cur].get(i);
				
				if (!visited[next]) {
					visited[next] = true;
					que.add(next);
				}
				
			}
			
		}
		
	}

}
