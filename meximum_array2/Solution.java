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
            int q = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            List<int[]> min = new ArrayList<>();
            List<int[]> mex = new ArrayList<>();
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                if (c == 1) {
                    min.add(new int[] {l , r});
                } else {
                    mex.add(new int[] {l , r});
                }
            }

            for (int[] p : min) {
                int l = p[0], r = p[1];
                for (int i = l; i <= r; i++) {
                    a[i] = k;
                }
            }

            int[] temp = a.clone();
            for (int[] p : mex) {
                int l = p[0], r = p[1];
                for (int i = l; i <= r; i++) {
                    if (temp[i] == k) {
                        a[i] = k + 1;
                    } else {
                        a[i] = i % k;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : a) {
                sb.append(x).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
