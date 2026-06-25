import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            // ceil of k / n
            // max of x number of seats per row
            long x = (k + n - 1) / n;
            // m - x + 1
            long ans = m / (m - x + 1);

            System.out.println(ans);
        }

    }
}
