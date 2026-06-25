import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s = br.readLine();
        solve(s);

    }

    static void solve(String s) {

        int n = s.length();
        int k = n / 2 + 1;
        for (int i = k; i < n; i++) {
            String first = s.substring(0, i);
            String second = s.substring(n - i);
            if (first.equals(second)) {
                System.out.println("YES");
                System.out.println(first);
                return;
            }
        }

        System.out.println("NO");

    }

}
