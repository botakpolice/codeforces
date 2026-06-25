import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()) * 2;
            int[] a = new int[2 * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] map = new int[n + 1];
            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            int y = 0;
            for (int i = 0; i < n; i++) {
                int x = a[i];
                map[x]++;
                if (map[x] == 2 && y + 2 <= k) {
                    b.add(x);
                    b.add(x);
                    y += 2;
                    map[x] = 0;
                }
            }

            k -= y;
            for (int i = 1; i <= n; i++) {
                if (map[i] == 1 && k > 0) {
                    b.add(i);
                    c.add(i);
                    k--;
                    map[i] = 0;
                }
            }

            map = new int[n + 1];
            for (int i = n; i < 2 * n; i++) {
                map[a[i]]++;
                if (map[a[i]] == 2 && y >= 2) {
                    c.add(a[i]);
                    c.add(a[i]);
                    y -= 2;
                    map[a[i]] = 0;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : b) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
            sb = new StringBuilder();
            for (int x : c) {
                sb.append(x).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

}

