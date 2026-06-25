import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            HashSet<Integer> ans = new HashSet<>();
            for (int i = 0; i <= 34; i++) {
                int x = l;
                boolean fail = false;
                for (int j = 0; j < i; j++) {
                    if (x % a != 0) {
                        fail = true;
                        break;
                    }

                    x /= a;
                }

                if (fail) {
                    break;
                }

                while (true) {
                    ans.add(x);

                    if (x % b != 0) {
                        break;
                    }

                    x/= b;
                }
            }
            System.out.println(ans.size());
        }
    }

}
