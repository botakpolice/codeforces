import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            HashSet<Integer> seen = new HashSet<>();
            TreeSet<Integer> dups = new TreeSet<>();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int x = a[i];
                if (seen.contains(x)) {
                    dups.add(x);
                }
                if (dups.isEmpty()) {
                    a[i] = 0;
                } else {
                    a[i] = dups.last();
                }

                sum += x;
                seen.add(x);
            }

            seen.clear();
            dups.clear();
            for (int i = 0; i < n; i++) {
                int x = a[i];
                if (seen.contains(x)) {
                    dups.add(x);
                }

                if (dups.isEmpty()) {
                    a[i] = 0;
                } else {
                    a[i] = dups.last();
                }

                sum += x;
                seen.add(x);
            }

            long presum = 0;
            for (int i = 0; i < n; i++) {
                presum += a[i];
            }

            sum += presum;
            for (int i = n - 1; i >= 0; i--) {
                sum += presum - a[i];
                presum -= a[i];
            }

            System.out.println(sum);
        }

    }
}
