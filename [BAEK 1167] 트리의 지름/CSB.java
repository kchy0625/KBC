import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Edge>[] adjList;
	static boolean[] visited;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[V + 1];
//		visited = new boolean[V + 1];
		
		for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<Edge>();
		
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			
			while (st.hasMoreTokens()) {
				int node = Integer.parseInt(st.nextToken());
				if (node == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				
				adjList[start].add(new Edge(node, weight));
			}
			
			
		}
		
		for (int i = 1; i <= V; i++) {
			visited = new boolean[V + 1];
			visited[i] = true;
			dfs(i, 0);
		}
		
		System.out.println(answer);
		
		
	}
	
	static void dfs(int start, int sum) {
		
		if (sum > answer) {
			answer = sum;
		}
		
		for (int i = 0; i < adjList[start].size(); i++) {
			Edge next = adjList[start].get(i);
			
			if (!visited[next.node]) {
				visited[next.node] = true;
				dfs(next.node, sum + next.weight);
				visited[next.node] = false;
			}
		}
		
	}

}

class Edge {
	public int node;
	public int weight;
	
	public Edge (int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}
