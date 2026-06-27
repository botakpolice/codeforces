import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int l = 1, r= n;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if ((i & 1) == 1) {
                    sb.append(l++).append(" ");
                } else {
                    sb.append(r--).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }

}
