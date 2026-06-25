import java.io.*;
import java.util.*;

public class simons_and_making_it_beautiful {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == n) {
                    int temp = a[0];
                    a[0] = n;
                    a[i] = temp;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : a) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
