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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int curr = 0;
            int res = 0;
            for (int l = 0, r = 0; r < n; r++) {

                curr += a[r];
                while (l <= r && curr > y) {
                    curr -= a[l++];
                }

                if (curr >= x) {
                    res++;
                    l = r + 1;
                    curr = 0;
                }
            }

            

            System.out.println(res);
        }

    }
}
