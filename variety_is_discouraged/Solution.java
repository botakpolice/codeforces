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
            int[] freq = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                freq[a[i]]++;
            }

            int[] len = new int[n];
            len[0] = freq[a[0]] == 1 ? 1 : 0;
            int max = len[0];
            for (int i = 1; i < n; i++) {
                if (freq[a[i]] == 1) {
                    len[i] = len[i - 1] + 1;
                }

                max = Math.max(max, len[i]);
            }

            if (max == 0) {
                System.out.println(0);
            } else {

                for (int i = 0; i < n; i++) {
                    if (len[i] == max) {
                        System.out.println(i - len[i] + 2 + " " + (i + 1) );
                        break;
                    }
                }
            }

        }

    }
}
