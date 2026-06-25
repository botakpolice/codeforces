import java.util.Scanner;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 100;
        while (sc.hasNextLine()) {

            int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int w = t[0], l = t[1];

            if (w == 0 && l == 0) {
                break;
            }

            int m = Integer.parseInt(sc.nextLine());
            int[] robot = new int[4];
            for (int i = 0; i < m; i++) {
                String[] c = sc.nextLine().trim().split(" ");
                String dir = c[0];
                int offset = Integer.parseInt(c[1]);
                if (dir.equals("u")) {
                    robot[1] = Math.min(robot[1] + offset, l - 1);
                    robot[3] = robot[3] + offset;
                }

                if (dir.equals("d")) {
                    robot[1] = Math.max(robot[1] - offset, 0);
                    robot[3] = robot[3] - offset;
                }

                if (dir.equals("l")) {
                    robot[0] = Math.max(robot[0] - offset, 0);
                    robot[2] = robot[2] - offset;
                }

                if (dir.equals("r")) {
                    robot[0] = Math.min(robot[0] + offset, w - 1);
                    robot[2] = robot[2] + offset;
                }
            }
            
            System.out.println(String.format("Robot thinks %d %d", robot[2], robot[3]));
            System.out.println(String.format("Actually at %d %d", robot[0], robot[1]));

        }
    }
}
