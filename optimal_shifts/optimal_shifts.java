import java.io.*;
import java.util.*;

public class optimal_shifts {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            s += s;
            int res = 0, curr = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    curr++;
                } else {
                    curr = 0;
                }
                res = Math.max(curr,res);
            }
            System.out.println(res);
        }
    }
}
