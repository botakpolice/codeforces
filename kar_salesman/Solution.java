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
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long mx = 0;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(st.nextToken());
                mx = Math.max(mx, k);
                sum += k;
            }


            System.out.println(Math.max(mx, (sum + x - 1)/x));
        }

    }
}
