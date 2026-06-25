import java.io.*;
import java.util.*;

public class arrays {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int a = nums[i];
                int less = 0, more = 0;
                for (int j = i + 1; j < n; j++) {
                    int b = nums[j];
                    if (b < a) {
                        less++;
                    } 
                    if (b > a) {
                        more++;
                    }
                }
                res[i] = Math.max(less, more);
            }
            System.out.println(Arrays.toString(res));

        }

    }
}
