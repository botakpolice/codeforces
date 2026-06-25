    // find number of ways to partition array into subarrays such that subarrays produce equal sum

    public static int getNumberOfPartitions(int[] arr) {

        int n = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum == 0) {
            int cnt = 0;
            int pre = 0;
            for (int i = 0; i < n - 1; i++) {
                pre += arr[i];
                if (pre == 0) {
                    cnt++;
                }
            }

            return (int) Math.pow(2, cnt);
        }

        int res = 0;
        HashSet<Integer> divisors = getDivisors(Math.abs(sum));
        for (int d : divisors) {
            int t = sum / d;

            int need = t;
            int cuts = 0;
            int x = 0;
            for (int num : arr) {
                x += num;
                if (x == need) {
                    need += t;
                    cuts++;
                }
            }

            if (cuts == d - 1 && need - t == sum) {
                res++;
            }
        }
        
        return res;
    }

    static HashSet<Integer> getDivisors(int n) {
        HashSet<Integer> divs = new HashSet<>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
