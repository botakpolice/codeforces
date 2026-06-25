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

            int[] h = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }

            int curr = h[k - 1];
            int dist = h[k - 1];

            Arrays.sort(h);
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (h[i] < curr) {
                    continue;
                } 
                if (h[i] - curr > dist) {
                    ok = false;
                    break;
                } 
                curr = h[i];
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
