import java.io.*;
import java.util.*;

public class distinct_elements {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] b = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            int[] a = new int[n];
            a[0] = 1;
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                int diff = (int) (b[i] - b[i - 1]); 
                if (i - diff >= 0) {
                    a[i] = a[i - diff];
                } else {
                    a[i] = ++cnt;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
