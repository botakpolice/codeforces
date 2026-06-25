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
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();

            for (int i = l - 1; i < n; i++) {
                b.add(a[i]);
            }

            for (int i = 0; i < r; i++) {
                c.add(a[i]);
            }

            b.sort(null);
            c.sort(null);

            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < r - l + 1; i++) {

                sum1 += b.get(i);
                sum2 += c.get(i);
            }

            System.out.println(Math.min(sum1, sum2));

        }

    }
}
