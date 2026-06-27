import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] firstDiff = new int[n];
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            HashMap<Integer,Integer> ctr = new HashMap<>();
            Arrays.fill(firstDiff, -1);
            for (int r = 0, l = 0; r < n; r++) {
                ctr.put(a[r], ctr.getOrDefault(a[r], 0) + 1);
                while (ctr.size() > 1) {
                    firstDiff[l] = r;
                    ctr.put(a[l], ctr.get(a[l]) - 1);
                    if (ctr.get(a[l]) == 0) {
                        ctr.remove(a[l]);
                    }
                    l++;
                }
            }

            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;

                int rr = firstDiff[l];
                if (rr == -1) {
                    System.out.println(-1 + " " + -1);
                } else {
                    if (rr <= r) {
                        System.out.println((l + 1) + " " + (rr + 1));
                    } else {
                        System.out.println(-1 + " " + -1);
                    }
                }
            }

            System.out.println();
        }
    }

}
