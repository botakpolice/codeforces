import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] b = new int[n];
            int res = 0;
            // 0 stands for right-caped,
            // 1 stands for left-caped
            b[0] = 0;
            res += check(a, b);
            b[0] = 1;
            res += check(a, b);
            System.out.println(res);

        }
    }

    static int check(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            b[i + 1] = (b[i] == 1 ? 1 : 0) - (a[i + 1] - a[i]);
            if (b[i + 1] < 0 || b[i + 1] > 1) {
                return 0;
            }
            b[i + 1] ^= 1;
        }
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum += (b[i] == 0 ? 1 : 0);
        }

        return sum == a[0] ? 1 : 0;
    }
}
