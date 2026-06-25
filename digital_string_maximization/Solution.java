import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            char[] s = br.readLine().toCharArray();
            int n = s.length;
            for (int i = 0; i < n; i++) {

                int best = s[i] - '0';
                int pos = i;

                for (int j = i; j < Math.min(i + 10, n); j++) {
                    if (s[j] - '0' - (j - i) > best) {
                        best = s[j] - '0' - (j - i);
                        pos = j;
                    }
                }

                while (pos > i) {
                    char temp = s[pos];
                    s[pos] = s[pos - 1];
                    s[pos - 1] = temp;
                    pos--;
                }

                s[i] = (char) (best + '0');
            }

            System.out.println(new String(s));
        }

    }
}
