import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int N = (int) (2e5 + 1);
        long[] res = new long[N];
        for (int i = 1; i < N; i++) {
            res[i] = res[i - 1] +  sumDigits(i);
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(res[n]);
        }
    }

    static int sumDigits(int n) {
        int x = 0;
        while (n > 0) {
            x += n % 10;
            n /= 10;
        }

        return x;
    }

}
