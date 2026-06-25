import java.util.*;

class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());

        for (int tc = 0; tc < c; tc++) {
            int[] a = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int n = a[0], t = a[1], m = a[2];

            Queue<int[]> left = new LinkedList<>();
            Queue<int[]> right = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                String[] b = sc.nextLine().split(" ");
                int x = Integer.parseInt(b[0]);
                if (b[1].equals("left")) {
                    left.add(new int[]{x, i});
                } else {
                    right.add(new int[]{x, i});
                }
            }

            int now = 0;
            boolean isLeft = true;
            int[] res = new int[m];

            while (!left.isEmpty() || !right.isEmpty()) {

                Queue<int[]> curr = isLeft ? left : right;
                Queue<int[]> other = isLeft ? right : left;

                // CASE 1: load cars if possible
                if (!curr.isEmpty() && curr.peek()[0] <= now) {

                    int cars = 0;
                    while (!curr.isEmpty() && curr.peek()[0] <= now && cars < n) {
                        res[curr.poll()[1]] = now + t;
                        cars++;
                    }

                    now += t;
                    isLeft = !isLeft;
                }

                // CASE 2: no cars ready on current side
                else {

                    int nextCurr = curr.isEmpty() ? Integer.MAX_VALUE : curr.peek()[0];
                    int nextOther = other.isEmpty() ? Integer.MAX_VALUE : other.peek()[0];

                    int next = nextCurr;
                    if (nextOther < nextCurr) next = nextOther;

                    // WAIT
                    if (now < next) {
                        now = next;
                    }
                    // MOVE EMPTY
                    else {
                        now += t;
                        isLeft = !isLeft;
                    }
                }
            }

            for (int v : res) {
                System.out.println(v);
            }

            if (tc != c - 1) System.out.println();
        }
    }
}
