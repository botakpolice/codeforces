import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            boolean ok = true;
            if (a[n - 1] != b[n -1]) {
                System.out.println("NO");
                continue;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (a[i] != b[i] && (a[i] ^ a[i + 1]) != b[i] && (a[i] ^ b[i + 1]) != b[i]) {

                    ok = false;
                    break;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
