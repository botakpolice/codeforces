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
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] s = br.readLine().toCharArray();
            int i = 0;
            int cnt = 0;
            int res = 0;
            while (i < n) {
                if (s[i] == '1') {
                    cnt = 0;
                    i++;
                } else {
                    cnt++;
                    if (cnt == m) {
                        res++;
                        i += k;
                        cnt = 0;
                    } else {
                        i++;
                    }
                }
            }

            System.out.println(res);
        }

    }
}
