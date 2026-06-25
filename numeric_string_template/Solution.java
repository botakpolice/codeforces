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
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            HashMap<Integer,Integer> mp1 = new HashMap<>();
            HashMap<Character,Integer> mp2 = new HashMap<>();
            for (int i = 0; i < m; i++) {
                char[] s = br.readLine().toCharArray();
                if (s.length != n) {
                    System.out.println("NO");
                    continue;
                }

                mp1.clear();
                mp2.clear();
                boolean ok = true;
                for (int j = 0; j < n; j++) {
                    int k = a[j];
                    char c = s[j];
                    if (mp1.get(k) == null) {
                        mp1.put(k, j);
                    }

                    if (mp2.get(c) == null) {
                        mp2.put(c, j);
                    }

                    if (mp1.get(k) != mp2.get(c)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }
        }

    }
}
