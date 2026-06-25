import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] revB = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                revB[n - 1 - i] = b[i]; 
            }

            boolean ok = Arrays.equals(a,revB) || Arrays.equals(a,b);
            if (ok) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }

    }
}
