import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        List<Integer> twentyseven = new ArrayList<>(Arrays.asList(1,2,2,3,3,4,4,5,5,1,6,6,7,7,8,8,9,9,10,10,11,11,12,13,13,1,12));
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    sb.append((i + 1)/ 2).append(" ");
                }
                System.out.println(sb.toString().trim());
                continue;
            } else {

                List<Integer> res = new ArrayList<>(twentyseven);
                if (n < 27) {
                    System.out.println(-1);
                } else {

                    int color = 14;
                    for (int pos = 28; pos <= n; pos += 2) {
                        res.add(color);
                        res.add(color);
                        color++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < res.size(); i++) {
                        sb.append(res.get(i)).append(" ");
                    }

                    System.out.println(sb.toString().trim());

                }
            }

        }

    }
}
