import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            char[] a = br.readLine().toCharArray();
            int ones = 0;
            for (int i = 0; i < n; i++) {
                ones += a[i] - '0';
            }

            int zeros = n - ones;
            int left = 0;
            int split = -1;
            
            int distanceToMiddle = Integer.MAX_VALUE;
            // use 2 * distance to avoid fractional issues with odd n;
            if (ones >= (n + 1) / 2) {
                split = 0;
                distanceToMiddle = n;
            }
            for (int i = 0; i < n; i++) {
                if (a[i] == '0') {
                    left++;
                }
                int curr_cut = i + 1;
                int right = ones - (curr_cut - left);
                boolean leftHalf = 2 * left >= curr_cut;
                boolean rightHalf = 2 * right >= (n - curr_cut);
                if(leftHalf && rightHalf) {
                    // n / 2 - currcut
                    // using 2 * (n / 2 - currcut);
                    // = n - curr_cut * 2;
                    int d = Math.abs(n - 2 * curr_cut);

                    if (d < distanceToMiddle) {
                        split = curr_cut;
                        distanceToMiddle = d;
                    }
                } 

            }

            System.out.println(split);
        }
    }

}
