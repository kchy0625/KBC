import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++){ 
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            graph.get(X).add(Y);
            graph.get(Y).add(X);
        }

        int count = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void dfs(int start){
        visited[start] = true;
        for(int next: graph.get(start)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
