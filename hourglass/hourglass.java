import java.io.*;
import java.util.*;

public class hourglass {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (s <= k) {
                System.out.println(Math.max(0, s - m % k));
            } else {
                if ((m % (2 *k)) < k) {
                    System.out.println(s - m % k);
                } else {
                    System.out.println(k - m % k);
                }
            }
        }
    }
}
