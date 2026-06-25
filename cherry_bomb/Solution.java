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
            int k = Integer.parseInt(st.nextToken());

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

            int s = -1;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (b[i] != -1) {
                    if (s == -1) {
                        s = a[i] + b[i];
                    } else {
                        if (s != a[i] + b[i]) {
                            ok = false;
                            break;
                        }
                    }
                }
            }

            if (!ok) {
                System.out.println(0);
                continue;
            }

            if (s == -1) {

                Arrays.sort(a);
                int mx = a[n - 1] - a[0];
                System.out.println(k - mx + 1);
                continue;
            }


            for (int i = 0; i < n; i++) {
                if (a[i] > s || s - a[i] > k) {
                    ok = false;
                }
            }

            if (ok) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }

    }
}
