import java.util.*;

class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();

            Pair pA = dfs(a, 0);
            Pair pB = dfs(b, 0);
            if (!pA.subtree.equals(pB.subtree)) {
                System.out.println("different");
            } else {
                System.out.println("same");
            }
        }
    }


    static Pair dfs(String a, int i) {
        List<String> children = new ArrayList<>();
        while (i < a.length() && a.charAt(i) == '0') {

            Pair p = dfs(a, i + 1);
            children.add(p.subtree);
            i = p.i;
        }

        Collections.sort(children);
        StringBuilder res = new StringBuilder("(");
        for (String child : children) {
            res.append(child); 
        }
        res.append(')');
        return new Pair(res.toString(), i + 1);
    }

    static class Pair {
        String subtree;
        int i ;

        Pair(String subtree, int i) {
            this.subtree = subtree;
            this.i = i;
        }
    }
}
