import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] s = br.readLine().toCharArray();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '1') {
                    cnt++;
                }
            }

            if (cnt <= k || 2 * k > n) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }

    }
}
