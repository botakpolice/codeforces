import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n = 200005;
        long[] a = new long[n];
        long[] psum = new long[n + 1];

        psum[0] = 0;
        for (int i = 1; i < n; i++) {
            a[i] = fun(i);
            psum[i] = psum[i - 1] + a[i];
        }

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long res = psum[r] - psum[l - 1] + a[l];

            System.out.println(res);

        }

    }


    static long fun(long x) {
        long cnt = 0;
        while (x > 0) {
            x /= 3;
            cnt++;
        }

        return cnt;
    }
}
