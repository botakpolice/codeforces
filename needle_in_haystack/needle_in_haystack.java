import java.io.*;
import java.util.*;

public class needle_in_haystack {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int[] ctr = new int[26];
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                ctr[c - 'a']--;
            }

            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                ctr[c - 'a']++;
            }

            boolean impossible = false;
            for (int i = 0; i < ctr.length; i++) {
                if (ctr[i] < 0) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Impossible");
                continue;
            }

            int i = 0;
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while (i < 26) {
                if (ctr[i] == 0) {
                    i++;
                    continue;
                }
                if (j < a.length()) {
                    int x = a.charAt(j) - 'a';
                    if (ctr[i] > 0 && i < x) {
                        for (int k = 0; k < ctr[i]; k++) {
                            sb.append((char) (i + 'a'));
                        }
                        i++;
                    } else {
                        sb.append((char) (x + 'a'));
                        j++;
                    }

                } else {
                    for (int k = 0; k < ctr[i]; k++) {
                        sb.append((char) (i + 'a'));
                    }
                    i++;
                }
            }
            while (j < a.length()) {
                sb.append(a.charAt(j++));
            }

            System.out.println(sb.toString());
        }
    }
}
