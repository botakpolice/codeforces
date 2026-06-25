import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = 0;
            int[] ctr = new int[m];
            List<Integer>[] v = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                v[i] = new ArrayList<>();
                for (int j = 0; j < l; j++) {
                    int x = Integer.parseInt(st.nextToken()) - 1;
                    if (ctr[x] == 0) {
                        k++;
                    }
                    ctr[x] += 1;
                    v[i].add(x);
                }
            }
            int ans = k == m ? 1 : 0;
            for (int i = 0; i < n; i++) {
                for (int x : v[i]) {
                    ctr[x]--;
                    if (ctr[x] == 0) {
                        k--;
                    }
                }
                ans += (k == m ? 1 : 0);
                for (int x : v[i]) {
                    if (ctr[x] == 0) {
                        k++;
                    }
                    ctr[x]++;
                }
            }

            if (ans >= 3) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
