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

            char[][] a = new char[n][m];
            for (int i = 0; i < n; i++) {
                a[i] = br.readLine().toCharArray();
            }

            int res = 0;

            int layers = Math.min(n, m) / 2;
            for (int layer = 0; layer < layers; layer++) {
                int top = layer;
                int left = layer;
                int bot = n - 1 - layer;
                int right = m - 1 - layer;
                List<Character> b = new ArrayList<>();
                for (int j = left; j <= right; j++) {
                    b.add(a[top][j]);
                }

                top++;
                for (int i = top; i <= bot; i++) {
                    b.add(a[i][right]);
                }
                right--;
                for (int j = right; j >= left; j--) {
                    b.add(a[bot][j]);
                }
                bot--;
                for (int i = bot; i >= top; i--) {
                    b.add(a[i][left]);
                }

                int k = b.size();
                for (int i = 0; i < k; i++) {
                    String s = "" + b.get(i) + b.get((i + 1) % k) + b.get((i + 2) % k) + b.get((i + 3) % k);
                    if (s.equals("1543")) {
                        res++;
                    }
                 }
            }



            System.out.println(res);
        }

    }
}
