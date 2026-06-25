import java.io.*;
import java.util.*;

public class alternating_paths_sol {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                g.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken()) - 1;
                int u = Integer.parseInt(st.nextToken()) - 1;
                g.get(v).add(u);
                g.get(u).add(v);
            }

            int[] clr = new int[n];
            Arrays.fill(clr, -1);

            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (clr[i] == -1) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    clr[i] = 0;

                    int[] cnt = new int[2];
                    boolean ok = true;

                    while (!q.isEmpty()) {
                        int v = q.poll();
                        cnt[clr[v]]++;

                        for (int u : g.get(v)) {
                            if (clr[u] == clr[v]) {
                                ok = false;
                            } else if (clr[u] == -1) {
                                clr[u] = clr[v] ^ 1;
                                q.add(u);
                            }
                        }
                    }

                    if (ok) {
                        ans += Math.max(cnt[0], cnt[1]);
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
