import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] s = br.readLine().toCharArray();

            Stack<Integer> openBrackets = new Stack<>();
            long res = 0;
            for (int i = 0; i < n; i++) {
                char c = s[i];
                if (c == '_') {
                    if (openBrackets.isEmpty()) {
                        c = '(';
                    } else {
                        c = ')';
                    }
                }

                if (c == ')') {
                    res += i - openBrackets.pop();
                } else {
                    openBrackets.push(i);
                }
            }

            System.out.println(res);
        }

    }
}
