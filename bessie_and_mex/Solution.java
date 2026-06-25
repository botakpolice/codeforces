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
            int[] p = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] m = new boolean[n + 1];
            int mex = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] >= 0) {
                    p[i] = mex;
                } else {
                    p[i] = mex - a[i];
                }
                m[p[i]] = true;
                while(m[mex]) {
                    mex++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : p) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());



        }
    }

}
