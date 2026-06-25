import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i-1] - arr[i] > 1) {
                arr[i-1]--;
                cnt++;
            }
        }
        cnt += arr[arr.length - 1] - 1;
        System.out.println(cnt);
    }
}
