import java.io.*;
import java.util.*;

public class flip_flops {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i] = a;
            }

            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                if (arr[i] > c) {
                    break;
                }
                long d = Math.min(k, c - arr[i]);
                k -= d;
                c += arr[i] + d;
            }

            System.out.println(c);
        }
    }
}
