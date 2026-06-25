import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] fib = new int[11];
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 2; i <= 10; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] a = new int[m][3];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                a[i] = new int[] {x, y, z};
                Arrays.sort(a[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
               
                if (a[i][0] >= fib[n - 1] && a[i][1] >= fib[n - 1] && a[i][2] >= fib[n]) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }

            System.out.println(sb.toString());

        }

    }
}
