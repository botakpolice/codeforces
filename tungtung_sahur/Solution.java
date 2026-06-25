import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            char[] p = br.readLine().toCharArray();
            char[] s = br.readLine().toCharArray();

            int n = p.length, m = s.length;
            if (m < n || m > 2 * n || p[0] != s[0]) {
                System.out.println("NO");
                continue;
            }

            List<Integer> a = new ArrayList<>();
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (p[i] != p[i - 1]) {
                    a.add(cnt);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }

            a.add(cnt);
            List<Integer> b = new ArrayList<>();
            cnt = 1;
            for (int i = 1; i < m; i++) {
                if (s[i] != s[i - 1]) {
                    b.add(cnt);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            b.add(cnt);

            if (a.size() != b.size()) {
                System.out.println("NO");
                continue;
            }

            boolean ok = true;
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) > b.get(i) || a.get(i) * 2 < b.get(i)) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

    }
}
