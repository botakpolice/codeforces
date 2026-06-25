import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            List<Integer> v = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                v.add(i);
            }

            v.add(22);
            v.add(11);
            int rem = (int) (n % 12);
            int a = v.get(rem);
            if (a <= n) {
                System.out.println(a + " " + (n - a));
            } else {
                System.out.println(-1);
            }


        }

    }

}
