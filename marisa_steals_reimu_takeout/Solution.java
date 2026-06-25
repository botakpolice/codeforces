import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int a = 0, b = 0, c = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 2) {
                    b++;
                } else if (x == 1) {
                    a++;
                } else {
                    c++;
                }
            }

            int min = Math.min(a,b);
            a -= min;
            b -= min;

            int res = c + min + (b / 3) + (a / 3); 
            System.out.println(res);
        }

    }
}
