import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());
        for (int tc = 0; tc < c; tc++) {
            int[] p = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = p[0], t = p[1], m = p[2];
            // can take n cars , takes t time
            PriorityQueue<int[]> left = new PriorityQueue<>((a,b) -> a[0] - b[0]);
            PriorityQueue<int[]> right = new PriorityQueue<>((a,b) -> a[0] - b[0]);

            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().split(" ");
                int x = Integer.parseInt(a[0]);
                String y = a[1];
                if (y.equals("left")) {
                    left.add(new int[]{x, i});
                } else {
                    right.add(new int[]{x , i});
                }
            }

            boolean onLeft = true;
            int currTime = 0;
            int[] res = new int[m];
            while (!left.isEmpty() || !right.isEmpty()) {
                int[] left_arrival = new int[] {Integer.MAX_VALUE, -1};
                int[] right_arrival  = new int[] {Integer.MAX_VALUE, -1};
                if (!left.isEmpty()){ 
                    left_arrival = left.peek(); 
                }
                if (!right.isEmpty()) {
                    right_arrival = right.peek();
                }

                int leftReadyTime = Math.max(currTime + (onLeft ? 0 : t), left_arrival[0]);
                int rightReadyTime = Math.max(currTime + (onLeft ? t : 0), right_arrival[0]);
                if (right_arrival[1] == -1 || leftReadyTime < rightReadyTime) {
                    int cars = 0;
                    while (!left.isEmpty() && left.peek()[0] <= leftReadyTime && cars < n) {
                        cars++;
                        res[left.poll()[1]] = leftReadyTime + t;
                    }
                    currTime = leftReadyTime + t;
                    onLeft = false;
                } else if (left_arrival[1] != -1 || rightReadyTime < leftReadyTime) {
                    int cars = 0;
                    while (!right.isEmpty() && right.peek()[0] <= rightReadyTime && cars < n) {
                        cars++;
                        res[right.poll()[1]] = rightReadyTime + t;
                    }
                    onLeft = true;
                    currTime = rightReadyTime + t;
                }

            }
            for (int k : res) {
                System.out.println(k);
            }




        }
    }
}

