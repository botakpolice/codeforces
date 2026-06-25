import java.io.*;
import java.util.*;

public class time_display_stickers {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] ctr = new int[10];
            String s = br.readLine();
            for (int i = 0; i < n; i++) {
                ctr[s.charAt(i) - '0']++;
            }

            int res = 0;
            while (true) {
                boolean made = false;

                for (int i = 0; i <= 1 && !made; i++) {
                    if (ctr[i] > 0) {
                        ctr[i]--;
                        int x = (i == 1 ? 1 : 9);

                        for (int j = x; j >= 0 && !made; j--) {
                            if (ctr[j] > 0) {
                                ctr[j]--;

                                for (int k = 5; k >= 0 && !made; k--) {
                                    if (ctr[k] > 0) {
                                        ctr[k]--;

                                        for (int l = 9; l >= 0; l--) {
                                            if (ctr[l] > 0) {
                                                ctr[l]--;
                                                res++;
                                                made = true;
                                                break;
                                            }
                                        }

                                        if (!made) ctr[k]++; // backtrack
                                    }
                                }

                                if (!made) ctr[j]++; // backtrack
                            }
                        }

                        if (!made) ctr[i]++; // backtrack
                    }
                }

                if (!made) break; // no more valid times
            }

            System.out.println(res);
        }
    }
}
