import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();

            int res = 0;
            for (int i = 0; i < b.length; i++) {
                int p = i;
                int cnt = 0;
                for (int j = 0; j < a.length; j++) {
                    if (p < b.length && a[j] == b[p]) {
                        cnt++;
                        p++;
                    }
                }

                res = Math.max(res, cnt);
            }

            System.out.println(a.length + b.length - res);

        }

    }
}
