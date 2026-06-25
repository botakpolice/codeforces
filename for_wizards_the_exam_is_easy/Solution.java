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

            int ans = 0;
            int ml = 1, mr = 1;

            for (int l = 0; l < n; l++) {
                int d = 0;
                for (int r = l + 1; r < n; r++) {
                    if (a[r] > a[l]) {
                        d++;
                    } else if (a[r] < a[l]) {
                        d--;
                    }

                    if (d < ans) {
                        ans = d;
                        ml = l + 1;
                        mr = r + 1;
                    }
                }
            }

            System.out.println(ml + " " + mr);
        }

    }
}
