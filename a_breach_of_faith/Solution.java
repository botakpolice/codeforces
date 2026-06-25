import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] b = new int[2 * n];
            long s = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);
            int k = 1;
            List<Long> a = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                a.add((long) b[i]);
                a.add((long) b[i + n - 1]);
                s += b[i + n - 1] - b[i];
            }

            a.add(s + b[n * 2 - 1] + b[0]);
            a.add((long)b[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(b[n * 2 - 1]).append(" ");
            for (int i = 0; i < 2 * n; i++) {
                sb.append(a.get(i)).append(" ");
            }

            System.out.println(sb.toString().trim());


        }

    }
}
