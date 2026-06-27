import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            // 1 4 7
            // 1 2 3 4 5 6 7
            // ai + k*pi = aj + k*pj
            // ai - aj = k(pj - pi);
            // 4 - 1 = 3 = k * (pj - pi);
            
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> uniques = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                uniques.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> a = new ArrayList<>(uniques);
            a.sort(null);
            int ans = 0;
            for (int r = 0, l = 0; r < a.size(); r++) {
                while (a.get(r) - a.get(l) >= n) {
                    l++;
                }

                ans = Math.max(ans, r - l + 1);
            }

            System.out.println(ans);
        }
    }

}
