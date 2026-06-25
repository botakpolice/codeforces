import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            boolean[] m = new boolean[n + 1];
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());            
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] prefixMex = new int[n];
            int mex = 0;
            for (int i = 0; i < n; i++) {
                m[a[i]] = true;
                while (m[mex]) {
                    mex++;
                }
                prefixMex[i] = mex;
            }

            int[] suffixMex = new int[n];
            mex = 0;
            m = new boolean[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                m[a[i]] = true;
                while (m[mex]) {
                    mex++;
                }
                suffixMex[i] = mex;
            }

            int split = -1;
            List<int[]> ans = new ArrayList<>();
            for (int i = 0; i < n - 1; i ++) {
                if (prefixMex[i] == suffixMex[i + 1]) {
                    ans.add(new int[] {1, i + 1});
                    ans.add(new int[] {i + 2, n});
                    break;
                }
            }

            if (ans.size() == 0) {
                System.out.println(-1);
            } else {
                System.out.println(2);
                for (int[] range : ans) {
                    System.out.println(range[0] + " " + range[1]);
                }
            }
        }

    }
}
