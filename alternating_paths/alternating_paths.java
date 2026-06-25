import java.io.*;
import java.util.*;

public class alternating_paths {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            HashSet<Integer>[] g = new HashSet[n + 1];
            for (int i = 0; i <= n; i++) {
                g[i] = new HashSet<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                g[u].add(v);
                g[v].add(u);
            }

            int[] colors = new int[n + 1];
            Arrays.fill(colors, -1);
            int res = 0;

            for (int i = 1; i <= n; i++) {
                if (colors[i] == -1) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    colors[i] = 0;

                    int[] cnt = new int[2];
                    boolean ok = true;

                    while (!q.isEmpty()) {
                        int u = q.poll();
                        cnt[colors[u]]++;

                        for (int v : g[u]) {
                            if (colors[v] == colors[u]) {
                                ok = false;
                            } else if (colors[v] == -1) {
                                colors[v] = 1 - colors[u];
                                q.add(v);
                            }
                        }
                    }
                    if (ok) {
                        res += Math.max(cnt[0], cnt[1]);
                    }
                }
            }

            System.out.println(res);
            
        }
    }
}
