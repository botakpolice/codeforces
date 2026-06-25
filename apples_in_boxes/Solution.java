import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }
            Arrays.sort(a);
            a[n - 1]--;
            Arrays.sort(a);
            if (a[n - 1] - a[0] >  k || sum % 2 == 0) {
                System.out.println("Jerry");
            } else { 
                System.out.println("Tom");
            }
        }

    }
}
