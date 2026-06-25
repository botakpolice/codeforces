import java.io.*;
import java.util.*;

public class table_with_numbers {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            int x = 0, y = n - 1;
            int res = 0;
            while (x < y) {

                int p1 = a[x], p2 = a[y];
                if (p2 > l && p2 > h) {
                    y--;
                } else {
                    if (p2 > Math.min(h, l) && p1 > Math.min(h, l)) {
                        break;
                    } else {
                        res++;
                        x++;
                        y--;
                    }
                }
            }

            System.out.println(res);
        }
    }
}
