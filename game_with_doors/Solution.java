import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            int inter = Math.min(r,R) - Math.max(l, L) + 1;
            if (inter <= 0) {
                System.out.println(1);
            } else {
                inter += l != L ? 1 : 0;
                inter += r != R ? 1 : 0;
                System.out.println(inter - 1);
            }
        }

    }
}
