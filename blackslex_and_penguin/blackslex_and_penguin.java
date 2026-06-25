import java.io.*;
import java.util.*;

public class blackslex_and_penguin {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {

            int n = Integer.parseInt(sc.nextLine());
            Integer[] arr = new Integer[1 << n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }

            Arrays.sort(arr, (a,b) -> {
                // ~a flips the bits
                // so this means getting number of trailing ones instead
                int ta = Integer.numberOfTrailingZeros(~a);
                int tb = Integer.numberOfTrailingZeros(~b);

                return ta != tb ? tb - ta : a - b;
            });

            StringBuilder sb = new StringBuilder();
            for (int x : arr) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
