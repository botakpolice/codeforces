import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            HashMap<Integer,Integer> a = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n * n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a.put(x, a.getOrDefault(x, 0) + 1);
                min = Math.min(min, x);
            }

            int[][] b = new int[n][n];
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = min + c * i + d * j; 
                    if (a.getOrDefault(b[i][j], 0) == 0) {
                        ok = false;
                        break;
                    } else {
                        a.put(b[i][j], a.get(b[i][j]) - 1);
                    }
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
