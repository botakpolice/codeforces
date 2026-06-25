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
            long[] a = new long[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            if (n == 1) {
                System.out.println(a[1] - a[0]);
                continue;
            }

            // for k = 1;
            LinkedList<Long> ansOdd = new LinkedList<>();
            LinkedList<Long> ansEven = new LinkedList<>();
            long ans = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {
                    ans -= a[i];
                }  else {
                    ans += a[i];
                }
            }
            ansOdd.add(ans);
            ans = a[2 * n - 1] - a[0];
            for (int i = 1; i < 2 * n - 1; i++) {
                if (i % 2 == 0) {
                    ans += a[i];
                } else {
                    ans -= a[i];
                }
            }
            ansEven.add(ans);
            for (int i = 1; i < n - 1; i += 2) {
                ansOdd.addLast(ansOdd.getLast() - 2 * a[i] + 2 * a[2 * n - 1 - i]);
            }
            
            for (int i = 2; i < n - 1; i += 2) {
                ansEven.addLast(ansEven.getLast() - 2 * a[i] + 2 * a[2 * n - 1 - i]);
            }

            StringBuilder sb = new StringBuilder();
            while (!ansEven.isEmpty()) {
                long x = ansOdd.pollFirst();
                long y = ansEven.pollFirst();

                sb.append(x).append(" ");
                sb.append(y).append(" ");
            }
            if (!ansOdd.isEmpty()) {
                sb.append(ansOdd.pollFirst());
            }
            System.out.println(sb.toString().trim());

        }

    }

}
