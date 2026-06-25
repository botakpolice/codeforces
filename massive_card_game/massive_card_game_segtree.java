import java.util.*;
import java.io.*;


class Solution {

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int lo = lowerBound(arr, l);
            int hi = upperBound(arr, r);

            int count = hi - lo;
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
        
    }

    static int lowerBound(int[] arr, int key) {

        int lo = 0, hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= key) {
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

    static int upperBound(int[] arr, int key) {


        int lo = 0, hi = arr.length;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] <= key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

}
