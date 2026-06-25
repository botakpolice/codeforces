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
            int q = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            int[] ones = new int[n + 1];
            int[] zeros = new int[n + 1];
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                ones[i + 1] = ones[i] + (a[i] == 1 ? 1 : 0);
                zeros[i + 1] = zeros[i] + (a[i] == 0 ? 1 : 0);
                if (i > 0 && a[i] == a[i - 1]) {
                    set.add(i - 1);
                }
            }

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                int numberOnes = ones[r + 1] - ones[l];
                int numberZeroes = zeros[r + 1] - zeros[l];
                if (numberOnes % 3 != 0 || numberZeroes % 3 != 0) {
                    System.out.println(-1);
                    continue;
                }
                Integer consecZeroes = set.ceiling(l);
                int triplets = numberOnes / 3 + numberZeroes / 3;
                if (consecZeroes == null || consecZeroes >= r) {
                    System.out.println(triplets + 1);
                } else {
                    System.out.println(triplets);
                }
            }
        }

    }
}
