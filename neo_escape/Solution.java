import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> a = new ArrayList<>();
            int inf = (int) (1e9 + 7);
            a.add(-inf);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x != a.get(a.size() - 1)) {
                    a.add(x);
                }
            }
            int ans = 0;
            a.add(-inf);
            for (int i = 1; i < a.size() - 1; i++) {
                if (a.get(i - 1) < a.get(i) && a.get(i) > a.get(i + 1)) {
                    ans++;
                }
            }

            System.out.println(ans);
        }

    }
}
