import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            // 1 only beats n
            // n only loses to 1.
            // if alice have 1 and n , alice wins
            // if bob has 1 and n, bob wins
            // if alice have 1 and bob has n
            // bob wins if bob cards > 2
            // if alice have n and bob has 1
            // if bob has n - 1, he wins, else alice wins

            char[] c = br.readLine().toCharArray();
            if (c[0] == c[n - 1]) {
                if (c[0] == 'A') {
                    System.out.println("Alice");
                    continue;
                } else {
                    System.out.println("Bob");
                    continue;
                }
            }

            if (c[0] == 'A' && c[n - 1] == 'B') {
                int cntB = 0;
                for (int i = 0; i < n; i++) {
                    if (c[i] == 'B') {
                        cntB++;
                    }
                }

                if (cntB >= 2) {
                    System.out.println("Bob");
                    continue;
                } else {
                    System.out.println("Alice");
                    continue;
                }
            }

            if (c[n - 1] == 'A' && c[0] == 'B') {
                if (c[n - 2] == 'A') {
                    System.out.println("Alice");
                    continue;
                } else {
                    System.out.println("Bob");
                    continue;
                }
            }

        
        }

    }
}
