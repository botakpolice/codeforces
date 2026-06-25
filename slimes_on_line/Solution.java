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
            int max = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, a[i]);
                min = Math.min(min, a[i]);
            }

            int mid = (max + min) / 2;

            int res = Math.max(max - mid, mid - min);
            System.out.println(res);
        }

    }
}
