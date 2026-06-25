import java.util.*;
import java.io.*;

public class Solution {

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
            }

            Arrays.sort(a);
            int min = a[0];
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] % min != 0) {
                    b.add(a[i]);
                }
            }
            if (b.isEmpty()) {
                System.out.println("YES");
            } else {
                b.sort(null);
                min = b.get(0);
                boolean ok = true;
                for (int x : b) {
                    if (x % min != 0) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }

}
