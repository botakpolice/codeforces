import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());


            System.out.println(get(r + 1) - get(l));
        }

    }

    static long get(long x) {
        return (x / 210) * get_naive(210) + get_naive(x % 210); 
    }

    static boolean good(long x) {
        return x % 2 > 0 && x % 3 > 0 && x % 5 > 0 && x % 7 > 0;
    }

    static int get_naive(long x) {
        int ans = 0;
        for (int i = 0; i < x; i++) {
            if (good(i)) {
                ans++;
            }
        }

        return ans;
    }
}
