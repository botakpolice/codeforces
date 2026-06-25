import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            System.out.println(2*n - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(i).append(" ").append(1).append(" ").append(i).append("\n");
                if (i != n) {
                    sb.append(i).append(" ").append(i + 1).append(" ").append(n).append("\n");
                }
            }

            System.out.println(sb.toString().trim());
        }

    }
}
