import java.io.*;
import java.util.*;

public class Solution {


    static int N = (int) (2e5 + 1);
    static ArrayList<Integer>[] pfac = new ArrayList[N + 1];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        // preprocess prime factors for 2e5 + 10 first;
        for (int i = 0; i <= N; i++) {
            pfac[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            if (!pfac[i].isEmpty()) {
                continue; // not a prime number;
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

            Map<Integer,Integer> cnt = new HashMap<>();
            int ans = 2;
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
                    if (cnt.getOrDefault(x, 0) > 0) {
                        ans = Math.min(ans, 1);
                    }
                }

                for (int x : pfac[a[i]]) {
                    cnt.put(x, cnt.get(x) + 1);
                }
            }

            System.out.println(ans);
        }

    }
}
