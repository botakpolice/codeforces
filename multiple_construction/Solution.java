import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = n; i >= 1; i--) {
                sb.append(i).append(" ");
            }
            sb.append(n).append(" ");
            for (int i = 1; i < n; i++) {
                sb.append(i).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }
}
