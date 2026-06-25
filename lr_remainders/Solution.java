import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            char[] queries = br.readLine().toCharArray();

            int l = 0, r = n - 1;
            for (int i = 0; i < n - 1; i++) {
                if (queries[i] == 'L') {
                    l++;
                } else {
                    r--;
                }
            }

            int[] b = new int[n];
            b[n - 1] = a[l] % m;
            for (int i = n - 2; i >= 0; i--) {
                if (queries[i] == 'L') {
                    b[i] = (b[i + 1] * a[--l] % m) % m;
                } else {
                    b[i] = (b[i + 1] * a[++r] % m) % m;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(b[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }

}
