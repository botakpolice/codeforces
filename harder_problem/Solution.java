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

            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(i + 1);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (set.contains(a[i])) {
                    sb.append(a[i]).append(" ");
                    set.remove(a[i]);
                } else {
                    int x = set.first();
                    sb.append(x).append(" ");
                    set.remove(x);
                }
            }

            System.out.println(sb.toString().trim());


        }

    }
}
