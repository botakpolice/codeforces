import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] coins = new int[] {1, 3, 6, 10, 15};
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            if (n < 10) {
                System.out.println(getAns(n));
            } else if (n < 20) {
                System.out.println(Math.min(getAns(n), getAns(n - 10) + 1));
            } else {
                System.out.println(Math.min(
                            getAns(n),
                            Math.min(getAns(n - 10) + 1,
                                getAns(n - 20) + 2                                )));
            }
        }
    }

    static int getAns(int n) {
        int ans = 0;
        ans += n / 15;
        n %= 15;
        ans += n / 6;
        n %= 6;
        ans += n / 3;
        n %= 3;
        ans += n;
        return ans;
    }

}
