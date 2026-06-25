import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            List<Integer>[] g = new ArrayList[n];
            int[] degrees = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                g[u].add(v);
                g[v].add(u);
                degrees[u]++;
                degrees[v]++;
            }

            if (n <= 3) {
                System.out.println(0);
                continue;
            }

            int c = 0, mx = 0;
            for (int i = 0; i < n; i++) {
                if (degrees[i] == 1) {
                    c++;
                }
            }

            for (int i = 0; i < n; i++) {
                int curr = 0;
                for (int v : g[i]) {
                    if (degrees[v] == 1) {
                        curr++;
                    }
                }
                mx = Math.max(curr, mx);
            }

            System.out.println(c - mx);
            
        }

    }
}
