import java.io.*;
import java.util.*;

public class secret_message {
    public static void main(String[] args) throws Exception { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[n][26];
            for (int i = 0; i < k; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    int c = (int) (s.charAt(j) - 'a');
                    map[j][c] = true;
                }
            }

            List<Integer> divisors = getDivisors(n);
            divisors.sort(null);

            for (int d : divisors) {

                char[] ans = new char[n];
                boolean ok = true;
                for (int i = 0; i < d; i++) {
                    boolean[] can = new boolean[26];
                    Arrays.fill(can, true);
                    for (int j = i; j < n; j += d) {
                        for (int c = 0; c < 26; c++) {
                            can[c] &= map[j][c];
                        }
                    }

                    int chosen = -1;
                    for (int c = 0; c < 26; c++) {
                        if (can[c]) {
                            chosen = c;
                            break;
                        }
                    }

                    if (chosen == -1) {
                        ok = false;
                        break;
                    }

                    for (int j = i; j < n; j += d) {
                        ans[j] = (char) (chosen + 'a');
                    }
                }

                if (ok) {
                    System.out.println(new String(ans));
                    break;
                }
            }
        }
    }

    static List<Integer> getDivisors(int n) {
        List<Integer> ds = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ds.add(i);
            } 
            if (n / i != i) {
                ds.add(n/i);
            }
        }

        return ds;
    }
}

