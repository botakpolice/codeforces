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

            HashMap<Integer,Integer> freq = new HashMap<>();
            long res = n;
            for (int x : a) {
                int complement = x ^ 0x7FFFFFFF;
                if (freq.getOrDefault(complement, 0) > 0) {
                    freq.put(complement, freq.get(complement) - 1);
                    res--;
                } else {
                    freq.put(x, freq.getOrDefault(x, 0) + 1);
                }

            }
            System.out.println(res);

        }
    }

}
