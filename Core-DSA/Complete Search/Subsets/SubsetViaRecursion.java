import java.util.ArrayList;
import java.util.List;

public class SubsetViaRecursion {

    static List<List<Integer>> subSets = new ArrayList<>();

    private static void generateSubsets(int k, int n, List<Integer> subs) {
        if (k > n) {
            subSets.add(new ArrayList<>(subs)); // add a copy
            return;
        }

        // Case 1: Exclude k
        generateSubsets(k + 1, n, subs);

        // Case 2: Include k
        subs.add(k);
        generateSubsets(k + 1, n, subs);
        subs.remove(subs.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        int n = 5;
        List<Integer> subs = new ArrayList<>();
        generateSubsets(1, n, subs);
        System.out.println(subSets);
    }
}
