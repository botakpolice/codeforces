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
                a[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            boolean[] vis = new boolean[n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {

                    int curr = i;
                    int x = 0;
                    while (!vis[curr]) {
                        x++;
                        vis[curr] = true;
                        curr = a[curr];
                    }

                    res += (x - 1) / 2;
                }
            }

            System.out.println(res);
        }

    }
}
