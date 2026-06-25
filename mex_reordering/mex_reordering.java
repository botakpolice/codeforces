import java.io.*;
import java.util.*;

public class mex_reordering {

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

            int[] ctr = new int[n + 1];
            for (int num : a) {
                ctr[num]++;
            }

            // if we dont have any 0, 
            // the min excluded at any cuts will be simply 0.
            if (ctr[0] == 0) {
                System.out.println("NO");
            } else if (ctr[1] > 0) {
                // if we have at least 1 zero and 1 one.
                System.out.println("YES");
            } else {
                if (ctr[0] == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }
}
