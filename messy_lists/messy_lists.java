import java.util.Scanner;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] ctr = new int[max + 1];
        for (int val : arr) {
            ctr[val]++;
        }

        int j = 0, wrongPositions = 0;
        for (int i = 0; i <= max; i++) {
            while(ctr[i] > 0) {
                if (arr[j] != i) {
                    wrongPositions++;
                }
                ctr[i]--;
                j++;
            }
        }

        System.out.println(wrongPositions);

    }
}


