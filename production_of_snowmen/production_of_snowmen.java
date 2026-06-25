import java.io.*;
import java.util.*;

public class production_of_snowmen {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            int k = 0, q = 0;
            for (int i = 0; i < n; i++) {
                if (good(a,b,n,i)) {
                    k++;
                } 

                if (good(b,c,n,i)) {
                    q++;
                }
            }

            System.out.println((long) k * q * n);
        }
    }
    static boolean good(int[] a, int[] b, int n, int k) {

        for (int i = 0; i < n; i++) {
            if (b[i] <= a[(i + k) % n]) {
                return false;
            }
        }

        return true;

    }
}
