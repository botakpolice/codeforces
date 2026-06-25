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
            int k = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(a);
            long prevTickets = 0;
            long res = 0;
            for (int i = 0; i < n; i++) {
                if (k >= m) {
                    res += (a[i] + prevTickets) * m;
                    prevTickets += m;
                    k -= m;
                } else {
                    res += (a[i] + prevTickets) * k;
                    break;
                }
            }

            System.out.println(res);
        }
    }

}
