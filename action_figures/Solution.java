import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] s = br.readLine().toCharArray();
            long res = 0;
            int c = 0;
            for (int i = n - 1; i >= 0; i--) { 
                if (c >= i) {
                    res += i + 1;
                    c--;
                    continue;
                }

                if (s[i] == '1') {
                    c++;
                } else {
                    res += i + 1;
                    c--;
                    if (c < 0) {
                        c = 0;
                    }
                }
            }


            System.out.println(res);

        }

    }
}
