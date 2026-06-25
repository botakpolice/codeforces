import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {


            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] ctr = new int[n + 1];
            HashSet<Integer> set = new HashSet<>();
            int max = 0;
            for (int i = 0; i < n; i++) {

                a[i] = Integer.parseInt(st.nextToken());
                ctr[a[i]]++;
                max = Math.max(max, ctr[a[i]]);
                set.add(a[i]);
            }

            System.out.println(Math.max(Math.min(max, set.size() - 1), Math.min(max - 1, set.size())));

        }
    }

}
