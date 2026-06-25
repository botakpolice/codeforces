import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<Integer> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){ 
                a.add(Integer.parseInt(st.nextToken()));
            }

            a.sort(null);
            List<Integer> l = new ArrayList<>();
            List<Integer> sl = new ArrayList<>();

            while (k > 0 && !l.equals(a)) {

                k -= 1;
                sl = new ArrayList<>(l);
                l = new ArrayList<>(a);
                int[] freq = new int[n + 1];
                for (int i : a) {
                    freq[i]++;
                }
                List<Integer> b = new ArrayList<>();
                int mex = 0;
                while (freq[mex] > 0) {
                    mex++;
                } 
                int mm = 0;
                for (int i : a) {
                    if (freq[i] > 1) {
                        b.add(mex);
                    } else {
                        b.add(mm);
                    }
                    if (i == mm) {
                        mm += 1;
                    }
                }
                b.sort(null);
                a = b;
                if (a.equals(sl)) {
                    k &= 1;
                }
            }

            long sum = 0;
            for (int x : a) {
                sum += x;
            }
            System.out.println(sum);
        }

    }
}
