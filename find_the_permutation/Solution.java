import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[][] g = new char[n][n];
            for (int i = 0; i < n; i++) {
                g[i] = br.readLine().toCharArray();
            }

            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = i;
            }

            Arrays.sort(a, (x, y) -> {
                if (g[x][y] == '1') {
                    return Integer.compare(x, y);
                } else {
                    return Integer.compare(y, x);
                }
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(a[i] + 1).append(" ");
            }

            System.out.println(sb.toString().trim());
            
        }

    }
}
