import java.io.*;
import java.util.*;

public class even_modulo_pair {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            LinkedList<Integer> evens = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a[i] = x;
                if (x % 2 == 0) {
                    evens.add(x);
                }
            }

            if (evens.size() >= 2) {
                System.out.println(evens.getFirst() + " " + evens.getLast());
                continue;
            }

            boolean ok = false;
            for (int i = 0; i < n; i++) {

                if (ok) {
                    break;
                }
                for (int j = 0; j < i; j++) {
                    if (a[i] % a[j] % 2 == 0) {
                        System.out.println(a[j] + " " + a[i]);
                        ok = true;
                        break;
                    }
                }
            }
            if (!ok) {
                System.out.println(-1);
            }

        }
    }
}
