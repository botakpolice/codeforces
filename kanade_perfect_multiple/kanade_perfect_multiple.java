import java.io.*;
import java.util.*;

public class kanade_perfect_multiple {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            TreeSet<Integer> set = new TreeSet<>();
            HashSet<Integer> seen = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
                seen.add(x);
            }

            List<Integer> res = new ArrayList<>();
            boolean ok = true;
            while (!set.isEmpty()) {
                int f = set.first();
                res.add(f);
                set.remove(f);

                for (int curr = f; curr <= k; curr += f) {
                    if (!seen.contains(curr)) {
                        ok = false;
                        break;
                    }

                    if (set.contains(curr)) {
                        set.remove(curr);
                    }
                }

                if (!ok) {
                    break;
                }
            }
            if (!ok) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int x : res) {
                    sb.append(x).append(" ");
                }
                System.out.println(res.size());
                System.out.println(sb.toString().trim());
            }
        }

    }
}
