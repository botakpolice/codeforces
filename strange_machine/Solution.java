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
            int q = Integer.parseInt(st.nextToken());
            char[] ch = br.readLine().toCharArray();
            boolean hasB = false;
            for (char c : ch) {
                if (c == 'B') {
                    hasB = true;
                    break;
                }
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < q; i++) {
                int a = Integer.parseInt(st.nextToken());
                if (!hasB) {
                    System.out.println(a);
                    continue;
                }
                int x = 0;
                int res = 0;
                while (a > 0) {
                    char c = ch[x % n];
                    if (c == 'B') {
                        a /= 2;
                    } else {
                        a -= 1;
                    }
                    x++;
                    res++;
                }
                System.out.println(res);
            }
        }
    }
}
