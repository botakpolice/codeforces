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
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();

            int[][] ctrA = new int[26][n + 1];
            int[][] ctrB = new int[26][n + 1];
            for (int i = 0; i < n; i++) {

                char c1 = a[i];
                char c2 = b[i];

                for (int c = 0; c < 26; c++) {
                    ctrA[c][i + 1] = ctrA[c][i];
                    ctrB[c][i + 1] = ctrB[c][i];
                }
                ctrA[c1 - 'a'][i + 1] = ctrA[c1 - 'a'][i] + 1;
                ctrB[c2 - 'a'][i + 1] = ctrB[c2 - 'a'][i] + 1;
            }

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;

                long res = 0;
                for (int j = 0; j < 26; j++) {
                    int cntA = ctrA[j][r + 1] - ctrA[j][l];
                    int cntB = ctrB[j][r + 1] - ctrB[j][l];
                    if (cntA > cntB) {
                        res += cntA - cntB;
                    }
                }

                System.out.println(res);
            }
        }

    }
}
