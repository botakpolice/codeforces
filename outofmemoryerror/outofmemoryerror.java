import java.io.*;
import java.util.*;

public class outofmemoryerror {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[n];
            int[] last = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int resetTime = 0;
            int time = 1;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());

                if (last[j] < resetTime) {
                    b[j] = 0;
                }

                last[j] = time;
                time++;
                b[j] += c;
                if (a[j] + b[j] > h) {
                    resetTime = time;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (last[i] < resetTime) {
                    b[i] = 0;
                }
                sb.append(a[i] + b[i]).append(" ");
            }

            System.out.println(sb.toString().trim());

        }

    }
}
