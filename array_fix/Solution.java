import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            boolean ok = true;
            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] < 10) {
                    if (a[i] >= prev) {
                        prev = a[i];
                    } else {
                        ok = false;
                        break;
                    }
                } else {
                    int d1 = a[i] / 10;
                    int d2 = a[i] % 10;

                    if (d1 >= prev && d2 >= d1) {
                        prev = d2;
                    } else if (a[i] >= prev) {
                        prev = a[i];
                    } else {
                        ok = false;
                        break;
                    }
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
