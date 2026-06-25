import java.util.*;

class Solution {

    public static void main(String[] args) {

        // so there is a list of cards
        // goal is to guess exactly what cards the oppoonent has
        // bin search
        // sort then binsearch r and binsearch lo

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            int[] query = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int l = query[0], r = query[1];
            int lo = lower(arr, l);
            int hi = upper(arr, r);
            int numCards = hi - lo;
            System.out.println(numCards);
        }

    }


    // the lower uses the original binsearch algorithm;
    // finds the first instance of key
    static int lower(int[] arr, int key) {

        int lo = 0, hi = arr.length;


        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            } 
        }

        if (lo < arr.length && arr[lo] < key) {
            lo++;
        }

        return lo;

    }

    // finds the last instance of key;
    static int upper(int[] arr, int key) {

        int lo = 0, hi = arr.length;

        while (lo < hi) {
            
            int mid = lo + (hi - lo) / 2;

            if (key >= arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

}
