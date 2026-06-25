import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            char[] s = br.readLine().toCharArray();
            int n = s.length;
            long shifts = 0;
            int ones = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '0') {
                    if (ones > 0) {
                        shifts += ones + 1;
                    }
                } else {
                    ones++;
                }
            }
            System.out.println(shifts);
        }
    }

}
