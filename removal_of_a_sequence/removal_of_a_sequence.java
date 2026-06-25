import java.io.*;
import java.util.*;

public class removal_of_a_sequence {

    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long inf = (long) (1e12 + 1);

            long l = 1, r = inf;
            while (l <= r) {
                long m = l + (r - l) / 2;
                long ost = m - 1;
                for (int i = 0; i < x; i++) {
                    ost -= ost / y;
                }

                if (ost + 1> k) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            if (r == inf) {
                System.out.println(-1);
            } else {
                System.out.println(r);
            }
        }
    }
}
