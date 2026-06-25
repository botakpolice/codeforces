import java.io.*;
import java.util.*;

public class array_and_permutation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] p = new int[n];
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                a[i] = v;
            }

            List<Integer> uniqueA = new ArrayList<>();
            if (n > 0) {
                uniqueA.add(a[0]);
                for (int i = 1; i < n; i++) {
                    if (a[i] != a[i - 1]) {
                        uniqueA.add(a[i]);
                    }
                }
            }

            int pa = 0, pp = 0;
            while(pp < n && pa < uniqueA.size()) {
                if (uniqueA.get(pa) == p[pp]) {
                    pa++;
                }
                pp++;
            }

            if (pa == uniqueA.size()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
