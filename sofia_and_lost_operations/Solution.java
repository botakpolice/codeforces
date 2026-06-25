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
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            HashMap<Integer,Integer> ctr = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int[] c = new int[m];
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                c[i] = x;
                ctr.put(x, ctr.getOrDefault(x, 0) + 1);
            }

            solve(ctr, a, b, c);
        }
    }

    static void solve(HashMap<Integer,Integer> ctr, int[] a, int[] b, int[] c) {

        int n = a.length;
        HashSet<Integer> set = new HashSet<>();
        for (int x : b) {
            set.add(x);
        }
        if (!set.contains(c[c.length - 1])) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                int x = ctr.getOrDefault(b[i], 0);
                if (x > 0) {
                    a[i] = b[i];
                    ctr.put(b[i], ctr.get(b[i]) - 1);
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
