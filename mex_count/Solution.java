import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer,Integer> mp = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }

            int mex = 0;
            Map<Integer,Integer> freq = new HashMap<>();
            for (Map.Entry<Integer,Integer> entry : mp.entrySet()) {
                int f = entry.getValue();
                int x = entry.getKey();
                if (x == mex) {
                    mex++;
                    freq.put(f, freq.getOrDefault(f, 0) + 1);
                }

            }

            int[] ans = new int[n + 1];
            ans[n] = ans[0] = 1;
            for (int i = n - 1; i > n - mex; i--) {
                ans[i] = ans[i + 1] + 1;
            }

            for (int i = 1; i < n; i++) {
                if (ans[i] != 0) {
                    break;
                }
                else {
                    ans[i] = ans[i - 1] + freq.getOrDefault(i, 0);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : ans) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());

        }

    }
}
