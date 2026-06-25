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
            long m = Long.parseLong(st.nextToken());

            if (m < n || ((long) n * (n + 1)) / 2 < m) {
                System.out.println(-1);
                continue;
            }

            int[] vals = new int[n];
            for (int i = 0; i < n; i++) {
                vals[i] = i + 1;
            }
            long rem = (long) n * (n + 1) / 2 - m;
            for (int i = n - 1; i >= 0; i--) {
                if (rem <= vals[i] - 1) {
                    vals[i] -= rem;
                    rem = 0;
                } else {
                    rem -= vals[i] - 1;
                    vals[i] = 1;
                }

                if (rem == 0) {
                    break;
                }
            }

            int root = -1;
            for (int i = 0; i < n; i++) {
                root = Math.max(vals[i], root);
            }

            System.out.println(root);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i + 1 == vals[i]) {
                    if (i + 1 == root) {
                        continue;
                    } else {
                        sb.append(vals[i] + " " + root + "\n");
                    }
                } else {
                    sb.append(i + 1).append(" ").append(vals[i]).append("\n");
                }                
            }

            System.out.println(sb.toString().trim());

        }

    }
}
