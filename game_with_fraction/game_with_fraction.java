import java.io.*;
import java.util.*;

public class game_with_fraction {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t -- > 0) {
    
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());

            if (p < q && Math.min(p / 2, q / 3) >= q - p) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }
}
