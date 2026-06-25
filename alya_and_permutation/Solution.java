import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> res = new ArrayList<>();
            if (n % 2 == 1) {
                res = solve(n - 1);
                res.add(n);
                System.out.println(n);
            } else {
                res = solve(n);
                System.out.println(res.get(n - 1) ^ res.get(n - 2));
            }

            StringBuilder sb = new StringBuilder();
            for (int x : res) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }

    static List<Integer> solve(int n) {
    
        List<Integer> res = new ArrayList<>();
        int lastNum = -1;
        int maxOrVal = -1;
        for (int i = 1; i < n; i++) {
            if ((i ^ n) > maxOrVal) {
                maxOrVal = (i ^ n);
                lastNum = i;
            }
        }
        for (int i = 1; i < n; i++) {
            if (i != lastNum) {
                res.add(i);
            }
        }

        res.add(n);
        res.add(lastNum);
        return res;

    }
}
