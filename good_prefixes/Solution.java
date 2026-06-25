import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            HashSet<Long> set = new HashSet<>();
            long currSum = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                set.add(a[i]);
                currSum += a[i];
                if (currSum % 2 == 0 && set.contains(currSum / 2)) {
                    res++;
                }
            }

            System.out.println(res);
        }

    }
}
