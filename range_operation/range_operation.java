import java.io.*;
import java.util.*;

public class range_operation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            long s = 0, min = 0, best = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                s += a[i];
                // newsum = (l + r)(r - l + 1);
                // oldsum = Sr - Sl-1
                // total_gain = newsum - oldsum
                // (l + r)(r - l + 1) - (Sr - Sl-1)
                // = r^2 - l^2 + l + r
                // = r^2 + r - Sr - (l^2 - l - Sl-1)
                // let f(x) = X^2 + x - Sx
                // f(r) = r^2 + r - Sr
                // f(l - 1) = (l - 1)^2 + (l - 1) - Sl-1
                // f(l - 1) = l^2 + 1 - 2l + l - 1 - Sl-1
                // f(l - 1) = l^2 - l - Sl - 1
                // This is equivalent to 
                // total gain
                // for every i, with s = si + 1,
                // we have the formula f(i + 1) = (i + 2) (i + 1) - si+1
                long curr = (long) (i + 1) * (i + 2) - s;
                min = Math.min(min, curr);
                best = Math.max(best, curr - min);
            }

            System.out.println(s + best);
        }
    }
}
