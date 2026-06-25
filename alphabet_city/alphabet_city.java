import java.io.*;
import java.util.*;

public class alphabet_city {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] letters = new int[n][26];
        int[] total = new int[26];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (char c : s.toCharArray()) {
                total[c - 'A']++;
                letters[i][c - 'A']++;
            }
        }

        System.out.println(Arrays.toString(total));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long res = m;
            int[] curr = letters[i];
            boolean can = true;
            for (int j = 0; j < 26; j++) {
                int needChar = curr[j];
                if (needChar == 0) {
                    continue;
                }

                int others = total[j] - curr[j];
                if (others <= 0) {
                    can = false;
                    break;
                }

                long need = (needChar + others - 1) / others;
                res = Math.min(res, m - need);
            }
            if (!can || res < 0) {
                sb.append(-1).append(" ");
            } else {
                sb.append(res).append(" ");
            }
        }
        System.out.println(sb.toString().trim());

    }
}
