import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;

            for (int i = 2; i < n; i++) {
                int left = 0, right = i - 1;

                while (left < right) {
                    if (a[left] + a[right] + a[i] > Math.max(2 * a[i], a[n - 1])) {
                        ans += right - left;
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
