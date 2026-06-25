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
            boolean[] seen = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                seen[a[i]] =  true;
            }

            int mex = 0;
            while (seen[mex]) {
                mex++;
            }

            Arrays.sort(a);
            List<Integer> singles = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boolean leftMatch = (i > 0 && a[i] == a[i - 1]);
                boolean rightMatch = (i < n - 1 && a[i] == a[i + 1]);

                if (!leftMatch && !rightMatch) {
                    singles.add(a[i]);
                }
            }

            if (singles.size() >= 2) {
                System.out.println(Math.min(mex, singles.get(1)));
            } else {
                System.out.println(mex);
            }
        }
    }

}
