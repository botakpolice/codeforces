import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            HashMap<Integer,Integer> ctr = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                int r = a[i] % k;
                ctr.put(r, ctr.getOrDefault(r , 0) + 1);
                ctr.put(k - r, ctr.getOrDefault(k - r, 0) + 1);
                
            } 

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                int r = b[i] % k;
                ctr.put(r, ctr.getOrDefault(r,0) - 1);
                ctr.put(k - r, ctr.getOrDefault(k - r, 0) - 1);
            }

            boolean ok = true;
            for (int val : ctr.values()) {
                if (val != 0) {
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
