import java.util.*;


class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int min = Integer.MAX_VALUE;
        char[] operators = {'+','-','*','/'};
        List<String> ops = new ArrayList<>();
        for (char c1 : operators) {
            for (char c2: operators) {
                ops.add("" + c1 + c2);
            }
        }

        for (String seq : ops) {
            int currSum = nums[0];
            int j = 1;
            boolean skip = false;
            for (char c : seq.toCharArray()){
                if (c == '/') {
                    if (currSum  % nums[j] != 0) {
                        skip = true;
                        break;
                    } else {
                        currSum /= nums[j];
                    }
                }

                if (c == '*') {
                    currSum *= nums[j];
                }

                if (c == '-') {
                    currSum -= nums[j];
                }

                if (c == '+') {
                    currSum += nums[j];
                }
                j++;
            }

            if (currSum >= 0 && !skip) {
                min = Math.min(min, currSum);
            }
        }

        System.out.println(min);

    }
}
