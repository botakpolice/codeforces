import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int mod = 998244353;
        int N = (int) 1e5 + 1;
        int[] s = new int[N];
        s[0] = 1;
        for (int i = 1; i < N; i++) {
            s[i] = (s[i - 1] * 2) % mod;
        }
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] p = new int[n];
            int[] q = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                q[i] = Integer.parseInt(st.nextToken());
            }

            int i,j;
            i = j = 0;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (p[k] > p[i]) {
                    i = k;
                }
                if (q[k] > q[j]) {
                    j = k;
                }

                if (p[i] != q[j]) {
                    if (p[i] > q[j]) {
                        long r = (s[p[i]] + s[q[k - i]]) % mod;
                        sb.append(r).append(" ");
                    } else {
                        long r = (s[q[j]] + s[p[k - j]]) % mod;
                        sb.append(r).append(" ");
                    }
                } else {
                    long r = (s[p[i]] + s[Math.max(q[k - i], p[k - j])]) % mod;
                    sb.append(r).append(" ");
                }
            }

            System.out.println(sb.toString().trim());
        }

    }
}
