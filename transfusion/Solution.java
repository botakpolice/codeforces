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

            long oddsum = 0;
            long evensum = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    evensum += a[i];
                } else {
                    oddsum += a[i];
                }
            }

            int oddCount = n / 2;
            int evenCount = n / 2;

            if (n % 2 == 1) {
                evenCount++;
            }

            if (evensum % evenCount != 0 || oddsum % oddCount != 0 || evensum / evenCount != oddsum / oddCount) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

    }
}
