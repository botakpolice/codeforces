import java.io.*;
import java.util.*;

public class dice_roll_sequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] seq = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }

            int res = 0;
            for (int i = 1; i < n; i++) {
                if (seq[i] == seq[i - 1] || (seq[i] + seq[i - 1] == 7)) {
                    res++;
                    i++;
                }
            }
            System.out.println(res);
        }
    }
}
