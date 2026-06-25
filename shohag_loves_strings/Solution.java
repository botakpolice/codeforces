import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s = br.readLine();
            solve(s);
        }

    }

    static void solve(String s) {
        int n = s.length();

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                System.out.println(s.substring(i - 1, i + 1));
                return;
            }
        }

        for (int i = 2; i < n; i++) {
            if (s.charAt(i - 2) != s.charAt(i - 1) && s.charAt(i - 1) != s.charAt(i) && s.charAt(i - 2) != s.charAt(i)) {
                System.out.println(s.substring(i - 2, i + 1));
                return;
            }
        }

        System.out.println(-1);
    }
}
