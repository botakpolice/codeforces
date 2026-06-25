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
            int q = Integer.parseInt(st.nextToken());


            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }


            HashSet<Integer> set = new HashSet<>();
            int i = 0;
            int j = 0;
            boolean ok = true;
            while (j < m) {
                if (set.contains(b[j])) {
                    j++;
                } else if (b[j] == a[i]) {
                    set.add(a[i]);
                    i++;
                    j++;
                } else {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                System.out.println("YA");
            } else {
                System.out.println("TIDAK");
            }
        }

    }
}
