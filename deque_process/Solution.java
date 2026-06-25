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

            StringBuilder sb = new StringBuilder();
            int l = 0, r = n - 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (a[r] > a[l]) {
                        sb.append("R");
                        r--;
                    } else {
                        sb.append("L");
                        l++;
                    }
                } else {
                    if (a[r] < a[l]) {
                        sb.append("R");
                        r--;
                    } else {
                        sb.append("L");
                        l++;
                    }
                }
            }
            System.out.println(sb.toString().trim());
        }

    }
}
