import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            List<Integer> v = new ArrayList<>();

            boolean ok = false;
            for (int i = 0; i < n; i++) {
                if (i == 0 || a[i] - a[i - 1] <= 1) {
                    v.add(a[i]);
                } else {

                    HashMap<Integer,Integer> freq = new HashMap<>();
                    int cnt = 0;
                    for (int j = 0; j < v.size(); j++) {

                        freq.put(v.get(j), freq.getOrDefault(v.get(j), 0) + 1);
                    }
                    for (int f : freq.values()) {
                        if (f >= 4){
                            ok = true;
                            break;
                        }
                        if (f > 1) {
                            cnt++;
                        }
                    }

                    if (cnt >= 2) {
                        ok = true;
                    }
                    v = new ArrayList<>();
                    v.add(a[i]);
                }

            }
            HashMap<Integer,Integer> freq = new HashMap<>();
            int cnt = 0;
            for (int j = 0; j < v.size(); j++) {
                freq.put(v.get(j), freq.getOrDefault(v.get(j), 0) + 1);
            }

            for (int f : freq.values()) {
                if (f >= 4) {
                    ok = true;
                    break;
                }
                if (f > 1) {
                    cnt++;
                }
            }

            if (cnt >= 2) {
                ok = true;
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }



        }

    }
}
