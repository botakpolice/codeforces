import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer,Integer> freq = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            // diff = stores where effect of mex begin and end 
            int[] diff = new int[n + 2];
            // ans[k] be the number of possible values after removing k elements from a
            // left side = min required operations to make mex = i
            // right side = maximum required operations to make mex = i
            // once number i is missing
            // mex is already locked in
            // lets say [0,1,2,4,5]
            // once i = 3, mex is locked in between 0,1,2 and 3.
            // larger values do not affect whether smaller values exist
            //
            int[] ans = new int[n + 1];
            for (int mex = 0; mex <= n; mex++) {
                diff[freq.getOrDefault(mex, 0)]++;
                diff[n - mex + 1]--;
                if (freq.getOrDefault(mex, 0) == 0) {
                    break;
                }
 
            }

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k <= n; k++) {
                ans[k] = (k > 0 ? ans[k - 1] : 0) + diff[k];
                sb.append(ans[k]).append(" ");
            }

            System.out.println(sb.toString().trim());

        }

    }
}
