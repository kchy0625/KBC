import java.io.*;
import java.util.*;

public class Main {

    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int [V+1];
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }


        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            int w =  Integer.parseInt(st.nextToken());
            edges.add(new int[]{a,b,w});
        }

        Collections.sort(edges,(a,b) -> a[2]-b[2]);

        int mstWeight = 0;
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];

            if(find(a) != find(b)){
                union(a,b);
                mstWeight += w;
            }
        }
        System.out.println(mstWeight);
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
