import java.io.*;
import java.util.*;

public class right_maximum {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int lastMax = 0, res = 0;
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x >= lastMax) {
                    res++;
                    lastMax = x;
                }
            }

            System.out.println(res);
        }
    }
}
