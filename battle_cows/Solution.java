import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()) -1;
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int curr = a[k];
            int swapIdx = -1;
            for (int i = 0; i < k; i++) {
                if (a[i] > curr) {
                    swapIdx = i;
                    break;
                }
            }

            int res = 0;
            if (swapIdx != -1) {
                a[k] = a[swapIdx];
                a[swapIdx] = curr;
                int c = 0;
                for (int i = swapIdx + 1; i < n; i++) {
                    if (a[i] > a[swapIdx]) {
                        break;
                    } else {
                        c++;
                    }
                }
                if (swapIdx > 0) {
                    c++;
                }
                res = Math.max(c, res);
                a[swapIdx] = a[k];
                a[k] = curr;
            }

            a[k] = a[0];
            a[0] = curr;
            int d = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] > a[0]) {
                    break;
                } else {
                    d++;
                }
            }
            res = Math.max(res, d);

            System.out.println(res);
        }
    }
}


