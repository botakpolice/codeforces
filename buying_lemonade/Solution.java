import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // 1 1 3 8 8 9 12 13 27 27
            // first get 10 * 1 cans
            // then waste 1 press
            // then get waste another press
            // then get 3 * 8 = 24 cans
            // then waste another press
            // then get the remaining cans

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            int sub = 0; 
            long res = k;
            for (int i = 0; i < n; i++) {
                a[i] -= sub;
                k -= Math.min(k, (long) a[i] * (n - i));
                if (k == 0) {
                    break;
                }
                
                res++;
                sub += a[i];

            }

            System.out.println(res);

        }

    }
}
