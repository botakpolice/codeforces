import java.io.*;
import java.util.*;

public class Solution2 {

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

            Arrays.sort(a);
            int leftReplace = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] + a[i - 1] <= a[n - 1]) {
                    leftReplace++;
                }
            }

            int rightReplace = 0;
            for (int i = n - 1; i > 0; i--) {
                if (a[0] + a[1] <= a[i]) {
                    rightReplace++;
                }
            }

            System.out.println(Math.min(leftReplace,rightReplace));
        }

    }
}
