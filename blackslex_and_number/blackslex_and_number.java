import java.util.*;

public class blackslex_and_number {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            sc.nextLine();
            Arrays.sort(a);
            System.out.println(Math.max(a[0], a[1] - a[0]));
        }
    }
}
