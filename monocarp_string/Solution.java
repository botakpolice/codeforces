import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int curr = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') {
                    curr++;
                } else {
                    curr--;
                }
            }

            HashMap<Integer,Integer> last = new HashMap<>();
            int prefix = 0;
            last.put(0, -1);

            int ans = n;
            for (int i = 0; i < n; i++) {

                if (s.charAt(i) == 'a') {
                    prefix++;
                } else {
                    prefix--;
                }

                last.put(prefix, i);
                if (last.containsKey(prefix - curr)) {
                    ans = Math.min(ans, i - last.get(prefix - curr));
                }
            }

            System.out.println(ans == n ? -1 : ans);

        }

    }
}
