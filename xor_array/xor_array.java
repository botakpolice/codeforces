import java.io.*;
import java.util.*;

public class xor_array {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] pre = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i == r) {
                    pre[i] = pre[l - 1];
                } else {
                    pre[i] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(pre[i + 1] ^ pre[i]).append(" ");
            }

            System.out.println(sb.toString().trim());

        }
    }
}
