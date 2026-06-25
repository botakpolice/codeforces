import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int N = (int) (6e6); 
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        List<Integer> p = new ArrayList<>();
        for (int i = 2; i < N; i++) {
            if (!isPrime[i]) {
                continue;
            }
            p.add(i);
            for (int j = i; j < N; j += i) {
                isPrime[j] = false;
            }
        }
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            int ans = 0;
            long sumA = 0, sumP = 0;
            for (int i = 0; i < n; i++) {
                sumA += a[n - 1 - i];
                sumP += p.get(i);
                if (sumA >= sumP) {
                    ans = i + 1;
                }
            }

            System.out.println(n - ans);
        }

    }
}
