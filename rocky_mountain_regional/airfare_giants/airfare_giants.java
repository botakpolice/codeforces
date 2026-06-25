import java.util.*;

class Solution {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(arr);

        double res = Math.max(0,arr[0] - arr[arr.length - 1] * 0.5); 
        System.out.println((int) res);
    }
}
