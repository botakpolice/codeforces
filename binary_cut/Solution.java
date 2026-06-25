import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int[] a = br.readLine().chars().map(x -> x - '0').toArray();
            int n = a.length;
            int res = 1;
            int ex = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] != a[i + 1]) {
                    res++;                    
                }
                if (a[i] < a[i + 1]) {
                    ex = 1;
                }
            }

            System.out.println(res - ex);
            
        }
    }

}
