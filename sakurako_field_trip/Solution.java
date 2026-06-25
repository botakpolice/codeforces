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

            for (int i = n / 2 - 1; i >= 0; i--) {
                int j = n - 1 - i;
                if (a[i] == a[i + 1] || a[j] == a[j - 1]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] == a[i + 1]) {
                    res++;
                }
            }
            
            System.out.println(res);
        }

    }

    static int getDisturbance(int[] a, int l, int r) {
        int cnt = 0;
        int n = a.length;
        return getD(a, l) + getD(a, r); 
    }

    static int getD(int[] a, int x) {
        int cnt = 0;
        int n = a.length;
        if (x < n - 1 && a[x] == a[x + 1]) {
            cnt++;
        }

        if (x > 0 && a[x] == a[x - 1]) {
            cnt++;
        }

        return cnt;
    }
}
