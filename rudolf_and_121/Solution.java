import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            boolean ok = true;
            for (int i = 0; i < n - 2; i++) {
                int op = a[i];
                if (a[i] < 0) {
                    ok = false;
                    break;
                }
                a[i] -= op;
                a[i + 1] -= 2 * op;
                a[i + 2] -= op;
            }

            if (a[n - 1] != 0 || a[n - 2] != 0) {
                ok = false;
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}
