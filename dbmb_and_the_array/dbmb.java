import java.io.*;
import java.util.*;

public class dbmb {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                s-= Integer.parseInt(st.nextToken());
            }

            if (s < 0 || s % x != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
