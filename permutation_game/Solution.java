import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            int[] p = new int[n];
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long s1 = dfs(a,p,p1,k,new boolean[n]);
            long s2 = dfs(a,p,p2,k,new boolean[n]);

            if (s1 == s2) {
                System.out.println("Draw");
            } else if (s1 > s2) {
                System.out.println("Bodya");
            } else {
                System.out.println("Sasha");
            }
        }
    }

    static long dfs(int[] a, int[] p, int x, int k, boolean[] visited) {
        if (k == 0) {
            return 0;
        }
        if (!visited[x - 1]) {
            long curr = (long) a[x - 1] * k;
            visited[x - 1] = true;
            curr = Math.max(curr, a[x - 1] + dfs(a,p,p[x - 1],k - 1, visited));
            return curr;
        } else {
            return 0;
        }


    }
}
