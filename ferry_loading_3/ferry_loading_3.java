import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());
        for (int tc = 0; tc < c; tc++) {
            int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = a[0], t = a[1], m = a[2];
            Queue<int[]> left = new LinkedList<>();
            Queue<int[]> right = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                String[] b = sc.nextLine().split(" ");
                int x = Integer.parseInt(b[0]);
                boolean y = b[1].equals("left");
                if (y) {
                    left.add(new int[]{x , i});
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

                // if we can load 
                if (!curr.isEmpty() && curr.peek()[0] <= now) {

                    int cars = 0;
                    while (!curr.isEmpty() && curr.peek()[0] <= now && cars < n) {
                        cars++;
                        res[curr.poll()[1]] = now + t;
                    }

                    now += t;
                    isLeft = !isLeft;
                } else {
                    if (curr.isEmpty()) {
                        if (!other.isEmpty()) {
                            if (other.peek()[0] > now) {
                                // fast forward now to other arrival time
                                now = other.peek()[0];
                            }
                            // since there is a movement from curr to other, we add t
                            now += t;
                            isLeft = !isLeft;
                        }

                    } else if (other.isEmpty()){
                        // just wait
                        now = curr.peek()[0];
                    } else {
                        if (other.peek()[0] >= curr.peek()[0]) {
                            // no movement, just waiting at current bank
                            now = curr.peek()[0];
                        } else {
                            // yes movement, going to other bank
                            now = other.peek()[0] + t;
                            isLeft = !isLeft;
                        }
                    }
                }
            }

            for (int v : res) {
                System.out.println(v);
            }
            System.out.println();
        }

    }
}
