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

            long ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // (ai + aj + ak > max(2*ai, an));
                    // max(2*ai, an) - ai - aj < ak
                    int x = Math.max(a[n - 1], 2 * a[i]) - a[i] - a[j];
                    int k = upperBound(a, 0, j, x);
                    ans += j - k;
                }
            }

            System.out.println(ans);
        }
    }

    static int upperBound(int[] a, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (a[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
