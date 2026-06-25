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
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            HashSet<Integer> b = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            if (n == k) {
                StringBuilder sb = new StringBuilder();
                for (int i =0 ;i < m; i++) {
                    sb.append(1);
                }
                System.out.println(sb.toString());
                continue;
            }

            if (k < n - 1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < m; i++) {
                    sb.append(0);
                }

                System.out.println(sb.toString());
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < m; i++) {
                    if (!b.contains(a[i])) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }

                System.out.println(sb.toString());
            }

        }

    }
}
