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
            int k = Integer.parseInt(st.nextToken());
            if (k == n * n - 1) {
                System.out.println("NO");
                continue;
            } else {
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (k > 0) {
                            sb.append("U");
                            k--;
                        } else if (i == n - 1 && j == n - 1) {
                            sb.append("L");
                        } else if (i == n - 1) {
                            sb.append("R");
                        } else {
                            sb.append("D");
                        }
                    }
                    System.out.println(sb.toString());
                }
            }

        }
    }
}
