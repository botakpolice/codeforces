import java.io.*;
import java.util.*;

public class renako_amaori_xor_game {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int x = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                x ^= a[i];
            }

            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                x ^= b[i];
            }

            if (x == 0) {
                System.out.println("Tie");
                continue;
            }

            int idx = 0;
            for (int i = 0; i < n; i++) {
                if ((a[i] ^ b[i]) == 1) {
                    idx = i;
                }
            }

            if (idx % 2 == 0) {
                System.out.println("Ajisai");
            } else {
                System.out.println("Mai");
            }
        }
    }
}
