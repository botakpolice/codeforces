import java.io.*;
import java.util.*;

public class another_mex_problem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a[i] = Math.min(n + 1, x);
            }

            boolean[] ctr = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                ctr[a[i]] = true;
            } 

            int mex = 0;
            while (ctr[mex]) {
                mex++;
            }

            System.out.println(Math.min(mex, k - 1));
        }
    }
}
