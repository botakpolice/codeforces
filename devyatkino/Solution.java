import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < 10; i++) {

                if (works(n, i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    static boolean works(int n , int k) {
        int m = n - k;

        int best = 10;

        while (m > 0) {
            int d = m % 10;

            best = Math.min(best, (7 - d + 10) % 10);
            m/= 10;
        }

        best = Math.min(best, 7);

        return best <= k;
    }
    
}
