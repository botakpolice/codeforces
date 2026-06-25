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
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int l = 0, r = n, res = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (check(a,mid,n,k)) {
                    l = mid + 1;
                    res = mid;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(res);
        }

    }

    static boolean check(int[] a, int mid, int n , int k) {

        if (mid == 0) {
            return true;
        }
        int[] seen = new int[mid];
        int token = 1;
        int cnt = 0;
        int distinct = 0;

        for (int x : a) {
            if (x < mid) {
                if (seen[x] != token) {
                    seen[x] = token;
                    distinct++;
                }
            }

            if (distinct == mid) {
                cnt++;
                if (cnt >= k) {
                    return true;
                }

                token++;
                distinct = 0;
            }
        }


        return false;
    }
}
