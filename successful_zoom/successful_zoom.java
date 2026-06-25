import java.util.*;


class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // discard everything except every kth number in the list
        // for some k >= 1;
        // find the smallest value of k such that 
        // lets brute force first
        
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int k = 1; k <= n/2; k++) {
            int last = arr[k - 1];
            boolean ok = true;
            int q = n / k;
            for (int i = 2; i < q + 1; i ++) {
                if (arr[i*k - 1] <= last) {
                    ok = false;
                    break;
                }

                last = arr[i*k - 1];
            }
            if (ok) {
                System.out.println(k);
                return;
            }
        }

        System.out.println("ABORT!");
    }
}
