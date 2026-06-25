import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] l = new int[n];
            int[] r = new int[n];
            int[] psum = new int[2 * n + 1];
            int[] cnt = new int[2 * n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                l[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());

                if (l[i] == r[i]) {
                    cnt[l[i]]++;
                    psum[l[i]] = 1;
                }
            }

            for (int i = 2; i <= 2 * n; i++) {
                psum[i] += psum[i - 1];
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (l[i] == r[i]) {
                    if (cnt[l[i]] <= 1) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                } else {
                    if (psum[r[i]] - psum[l[i] - 1] < r[i] - l[i] + 1) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.println(sb.toString().trim());

        }

    }
}
