import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            solve(a);
        }
    }


    static void solve(int[] a) {
        int n = a.length;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for (int i = 0; i < n - 1; i++) {
            int diff = a[i + 1] - a[i];
            tm.put(diff, tm.getOrDefault(diff, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {

            if (a[i] == a[i + 1]) {
                int c = a[i];
                if (tm.get(0) > 1) {
                    tm.put(0, tm.get(0) - 1);
                } else {
                    tm.remove(0);
                }
                if (i > 0) {
                    int prevDiff = a[i] - a[i - 1];
                    if (tm.get(prevDiff) > 1) {
                        tm.put(prevDiff, tm.get(prevDiff) - 1);
                    } else {
                        tm.remove(prevDiff);
                    }
                }

                if (i < n - 2) {
                    int nextDiff = a[i + 2] - a[i + 1];
                    if (tm.get(nextDiff) > 1) {
                        tm.put(nextDiff, tm.get(nextDiff) - 1);
                    } else {
                        tm.remove(nextDiff);
                    }
                }


                if (!tm.isEmpty() && tm.firstKey() < 2 * c) {

                    for (int j = 0; j < n; j++) {

                        if (a[j + 1] - a[j] < 2 * c && (j + 1 < i || i + 1 < j)) {
                            System.out.println(a[j + 1] + " " + a[j] + " " + c + " " + c);
                            return;
                        }
                    }
                }

                if (i > 0 && i + 2 < n && a[i + 2] - a[i - 1] < 2 * c) {
                    System.out.println(a[i - 1] + " " + a[i + 2] + " " + c + " " + c);
                    return;
                }

                tm.put(0, tm.getOrDefault(0, 0) + 1);
                if (i > 0) {
                    int prevDiff = a[i] - a[i - 1];
                    tm.put(prevDiff, tm.getOrDefault(prevDiff, 0) + 1);
                }

                if (i < n - 2) {
                    int nextDiff = a[i + 2] - a[i + 1];
                    tm.put(nextDiff, tm.getOrDefault(nextDiff,0) + 1);
                }
            }
        }

        System.out.println(-1);
    }
}
