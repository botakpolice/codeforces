import java.io.*;
import java.util.*;

public class yet_another_array_problem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            
            long[] divs = new long[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};
            for (long x : divs) {
                boolean ok = false;
                for (long i : a) {
                    if (i % x == 1) {
                        ok = true;
                        break;
                    }
                }
                if (ok) {
                    System.out.println(x);
                    break;
                }
            }

        }
    }
}
