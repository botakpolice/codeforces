import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int lo = 1, hi = n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (check(a,mid)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(lo);
        }
    }

    static boolean check(int[] a, int k) {

        int[] bits = new int[22];
        int n = a.length;
        for (int i = 0; i < k; i++) {
            int x = a[i];
            int j = 0;
            while (x > 0) {
                if (x % 2 == 1) {
                    bits[j]++;
                }
                j++;
                x /= 2;
            }
        }

        int[] freq = new int[22];
        for (int i = 0; i < 22; i++) {
            freq[i] = bits[i];
        }

        for (int i = k; i < n; i++) {
            int prev = a[i - k];
            int next = a[i];
            int j = 0;
            while (prev > 0) {
                if (prev % 2 == 1) {
                    freq[j]--;
                }
                j++;
                prev /= 2;
            }

            j = 0;
            while (next > 0) {
                if (next % 2 == 1) {
                    freq[j]++;
                }
                j++;
                next /= 2;
            }

            for (int x = 0; x < 22; x++) {
                if (bits[x] > 0 && freq[x] == 0) {
                    return false;
                }
                if (bits[x] == 0 && freq[x] > 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
