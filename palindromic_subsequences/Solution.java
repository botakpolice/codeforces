import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 6) {
                System.out.println("1 1 2 3 1 2");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n - 2; i++) {
                    sb.append(i).append(" ");
                }
                sb.append("1 2");
                System.out.println(sb.toString().trim());
            }
        }

    }
}
