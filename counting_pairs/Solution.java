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
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }

            Arrays.sort(a);
            long res = 0;
            for (int i = n - 1; i >= 0; i--) {
                long rem = sum - a[i];
                int l = lowerBound(a, rem - y);
                int r = upperBound(a, rem - x);
                res += Math.max(0, r - l);
                if (l <= i && i < r) {
                    res--;
                }
            }

            System.out.println(res / 2);
        }

    }

    static int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }


    static int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
