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
            int x = Integer.parseInt(st.nextToken());

            int[] res = new int[n];
            Arrays.fill(res, x);
            int or_val = 0;
            boolean flag = true;
            for (int i = 0; i < n - 1; i++) {
                if ((i | x) == x) {
                    or_val |= i;
                    res[i] = i;
                } else { 
                    flag = false;
                    break;
                }
            }

            if (flag && (or_val | (n - 1)) == x) {
                res[n - 1] = n - 1;
            }


            StringBuilder sb = new StringBuilder();
            for (int k : res) {
                sb.append(k).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }
}
