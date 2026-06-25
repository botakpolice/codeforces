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
            long k = Long.parseLong(st.nextToken());

            int l = 1, r = m;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if ((long) n * (mid * (m / (mid + 1)) + m % (mid + 1)) >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println(l);
        }

    }
}
