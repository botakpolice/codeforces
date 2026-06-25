import java.io.*;
import java.util.*;

public class beautiful_xor {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int msba = Integer.numberOfLeadingZeros(a);
            int msbb = Integer.numberOfLeadingZeros(b);
            if (msba > msbb) {
                System.out.println(-1);
                continue;
            } else if (a == b) {
                System.out.println(0);
                continue;
            } else {
                List<Integer> res = new ArrayList<>();
                // get all to 11111 representation first
                for (int i = 0; i < 31; i++) {
                    int x = (1 << i);
                    if (x <= a && (a & x) == 0) {
                        a += x;
                        res.add(x);
                    }
                }

                System.out.println(a);


                for (int i = 0; i < 31; i++) {
                    int x = (1 << i);
                    if (x <= a && (b & x) == 0) {
                        res.add(x);
                    }
                }

                //System.out.println(res.size());
                StringBuilder sb = new StringBuilder();
                for (int x : res) {
                    sb.append(x).append(" ");
                }

                //System.out.println(sb.toString().trim());
            }
        }
    }
}
