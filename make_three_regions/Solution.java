import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            // at most 1 connected region
            // or no connected region

            int n = Integer.parseInt(br.readLine());
            char[] top = br.readLine().toCharArray();
            char[] bot = br.readLine().toCharArray();

            long res = 0;
            for (int i = 1; i < n - 1; i++) {
                boolean x = (top[i - 1] == 'x' && top[i + 1] == 'x');
                x &= (top[i] == '.' && bot[i] == '.');
                x &= (bot[i - 1] == '.' && bot[i + 1] == '.');
            
                boolean y = (bot[i - 1] == 'x' && bot[i + 1] =='x');
                y &= (bot[i] == '.' && top[i] == '.');
                y &= (top[i - 1] == '.' && top[i + 1] == '.');

                if (x || y) {
                    res++;
                }


            }

            System.out.println(res);

        }

    }
}
