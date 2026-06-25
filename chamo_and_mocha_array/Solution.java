import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            if (n == 2) {
                System.out.println(Math.min(a[0], a[1]));
            } else {
                int res = 0;
                for (int i = 1; i < n - 1; i++) {
                    List<Integer> temp = new ArrayList<>();
                    for (int j = -1; j <= 1; j++) {
                        temp.add(a[i + j]);
                    }
                    temp.sort(null);
                    res = Math.max(res, temp.get(1));
                }

                System.out.println(res);
            }
        }
    }

}
