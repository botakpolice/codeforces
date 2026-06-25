import java.io.*;
import java.util.*;

public class addition_on_segment {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            int res = 0;
            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                b[i] = x;
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int x = b[i];
                if (x > 0) {
                    cnt++;
                }

                sum += x;
            }

            int additionals = sum - cnt;
            int sub = n - 1 - additionals;

            System.out.println(cnt - Math.max(0, sub));
        }
    }
}
