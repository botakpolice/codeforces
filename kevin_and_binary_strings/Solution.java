import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            int n = s.length();

            // Find first 0
            int p = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    p = i; // 0-based
                    break;
                }
            }

            // Entire string is all 1's
            if (p == -1) {
                System.out.println("1 " + n + " 1 1");
                continue;
            }

            // Length of first block of consecutive 0's
            int q = 0;
            int j = p;
            while (j < n && s.charAt(j) == '0') {
                q++;
                j++;
            }

            int prefixOnes = p; // p-1 in 1-based indexing

            int k = Math.min(prefixOnes, q);

            int l2 = p - k;           // 0-based
            int len = n - p;          // n - p + 1 in 1-based indexing

            int r2 = l2 + len - 1;

            // Output in 1-based indexing
            System.out.println(
                "1 " + n + " " +
                (l2 + 1) + " " +
                (r2 + 1)
            );
        }
    }
}
