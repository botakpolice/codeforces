import java.io.*;
import java.util.*;

public class loyalty {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[] a = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            int l = 0, r = n - 1;
            long s = 0, res = 0;
            List<Integer> al = new ArrayList<>();
            while (l <= r) {
                long need = x - (s % x);
                if (a[r] >= need) {
                    s += a[r];
                    res += a[r];
                    al.add(a[r]);
                    r--;
                    continue;
                } else {
                    s += a[l];
                    al.add(a[l]);
                    l++;
                    continue;
                }
            }
            System.out.println(res);
            StringBuilder sb = new StringBuilder();
            for (int k : al) {
                sb.append(k).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
