import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Integer> pos = new ArrayList<>();
            boolean[] used = new boolean[n];
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                p[i] = x; 
                if (x == -1) {
                    pos.add(i);
                } else {
                    used[x] = true;
                }
            }

            if (pos.size() == 1) {
                int unused = 0;
                for (int i = 0; i < n; i++) {
                    if (!used[i]) {
                        unused = i;
                    }
                }
                p[pos.get(0)] = unused;
            }

            int l = 0, r = n - 1;
            while (l < n && p[l] == l) {
                l++;
            }
            while(r >= 0 && p[r] == r) {
                r--;
            }

            System.out.println(Math.max(0, r - l + 1));
        }

    }
}
