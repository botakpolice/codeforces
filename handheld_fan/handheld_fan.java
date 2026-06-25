import java.util.*;

class Solution {

    public static void main(String[] args) {

        // fan battery can operate for W hours
        // for an hour with T degrees,
        // operate the fan for exactly T/30 for every hour
        // output m, the max number of consecutive hours you are able to attend the festival if you choose the first hour optimally.
        
        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = t[0], w = t[1] * 30;
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currSum = 0, max = 0;
        for (int r = 0, l = 0; r < arr.length; r++) {
            
            currSum += arr[r];
            while (currSum > w) {
                currSum -= arr[l++];
            }

            max = Math.max(r - l + 1, max);
        }

        System.out.println(max);

    }
}
