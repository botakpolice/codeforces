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
            st = new StringTokenizer(br.readLine());
            for (int i= 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            HashSet<Integer> curr = new HashSet<>();
            HashSet<Integer> seen = new HashSet<>();
            int res = 0;
            for (int i = 0; i < n; i++) {
                curr.add(a[i]);
                seen.add(a[i]);
                if (seen.size() == curr.size()) {
                    res++;
                    seen.clear();
                }
            }

            System.out.println(res);
        }

    }
}
