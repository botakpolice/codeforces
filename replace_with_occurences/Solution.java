import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] freq = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                freq[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                freq[b[i]].add(i);
            }

            int[] a = new int[n];
            boolean ok = true;
            int cnt = 1;
            for (int i = 1; i < n + 1; i++) {
                if (freq[i].size() % i != 0) {
                    ok = false;
                    break;
                } else {
                    int c = 0;
                    while (c < freq[i].size()) {
                        for (int v = 0; v < i; v++) {
                            a[freq[i].get(c)] = cnt;
                            c++;
                        }
                        cnt++;
                    }
                }
            }
            if (!ok) {
                System.out.println(-1);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }

    }
}
