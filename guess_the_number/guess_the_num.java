import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lo = 1, hi = 1000;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            System.out.println(mid);
            System.out.flush();

            String r = sc.nextLine().trim();
            if (r.equals("lower")) {
                hi = mid - 1;
            } else if (r.equals("higher")) {
                lo = mid + 1;
            } else {
                return;
            }
        }
    }
}
