import java.io.*;
import java.util.*;

public class Solution {

    static int N = (int) (2e5 + 1); 
    static List<Integer>[] pfac = new ArrayList[N + 1];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        // preprocess first
        for (int i = 0; i <= N; i++) {
            pfac[i] = new ArrayList<>();
        }
        for (int i = 2; i <= N; i++) {
            if (!pfac[i].isEmpty()) {
                continue;
            }

            for (int j = i; j <= N; j += i) {
                pfac[j].add(i);
            }
        }

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Integer[] ord = new Integer[n];
            for (int i = 0; i < n; i++) {
                ord[i] = i;
            }
            Arrays.sort(ord, (x,y) -> b[x] - b[y]);
            Map<Integer,Integer> cnt = new HashMap<>();
            long ans = b[ord[0]] + b[ord[1]];
            for (int i = 0; i < n; i++) {
                for (int x : pfac[a[i]]) {
                    if (cnt.getOrDefault(x, 0) > 0) {
                        ans = 0;

                    }
                    cnt.put(x, cnt.getOrDefault(x, 0) + 1);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int x : pfac[a[i]]) {
                    cnt.put(x, cnt.get(x) - 1);
                }

                for (int x : pfac[a[i] + 1]) {
                    if (cnt.getOrDefault(x,0) > 0) {
                        ans = Math.min(ans, b[i]);
                    }
                }

                for (int x : pfac[a[i]]) {
                    cnt.put(x, cnt.get(x) + 1);
                }
            }

            int idx = ord[0];
            HashSet<Integer> check = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (i == idx) {
                    continue;
                }

                for (int x : pfac[a[i]]) {
                    check.add(x);
                }
            }

            for (int x : check) {
                int times = x - (a[idx] % x);
                if (times == x) {
                    times = 0;
                }

                ans = Math.min(ans, (long) times * b[idx]);
            }

            System.out.println(ans);

        }

    }
}
