import java.io.*;
import java.util.*;


public class red_black_pairs {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();
            int res = 0;
            int i = 0;
            while (i < n) {
    
                int v = (a.charAt(i) != b.charAt(i)) ? 1 : 0;
                if (i + 1 < n) {
                    int h = (a.charAt(i) != a.charAt(i + 1) ? 1 : 0) +
                        (b.charAt(i) != b.charAt(i + 1) ? 1 : 0);

                    if (h < v) {
                        res += h;
                        i += 2;
                        continue;
                    }
                }
                res += v;
                i++;
            }
            System.out.println(res);
        }

    }

}

