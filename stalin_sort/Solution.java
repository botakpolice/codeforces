import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            // stalin sort makes it increasing.
            
            int best = 0;
            for (int i = 0; i < n; i++) {
                int curr = 0;
                for (int j = i; j < n; j++) {
                    if (a[j] <= a[i]) {
                        curr++;
                    }
                }


                best = Math.max(best, curr);
            }

            System.out.println(n - best);
        }

    }
}
