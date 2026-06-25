import java.io.*;
import java.util.*;

public class lost_civilization_easy {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t -- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i <  n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int res = 1;
            int l = a[0], r = a[0];
            for (int i = 1; i < n; i++) {
                if (a[i] <= l || r + 1 < a[i]) {
                    System.out.println(a[i]);
                    l = a[i];
                    r = a[i];
                    res++;
                } else {
                    r = a[i];
                    System.out.println(r);
                }
            }
            System.out.println(res);

        }
    }
}
