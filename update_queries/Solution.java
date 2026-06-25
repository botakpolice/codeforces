import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[] s = br.readLine().toCharArray();
            TreeSet<Integer> set = new TreeSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                set.add(x);
            }
            char[] c = br.readLine().toCharArray();
            int j = 0;
            Arrays.sort(c);
            for (int x : set) {
                s[x] = c[j++];
            }

            System.out.println(new String(s));
        }

    }
}
