import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] x = new long[n];
            long[] y = new long[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x[i] = Long.parseLong(st.nextToken());
                y[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            long xs = Long.parseLong(st.nextToken());
            long ys = Long.parseLong(st.nextToken());
            long xt = Long.parseLong(st.nextToken());
            long yt = Long.parseLong(st.nextToken());

            long d = dist(xs,ys,xt,yt);

            boolean ok = true;
            for (int i = 0; i < n; i++) {

                long d1 = dist(x[i],y[i], xt, yt);
                if (d1 <= d) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }


    }

    static long dist(long x1, long y1, long x2, long y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }


}

