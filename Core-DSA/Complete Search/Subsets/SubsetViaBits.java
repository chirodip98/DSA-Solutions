
import java.util.*;

public class SubsetViaBits {
    public static void main(String[] args) {
        int n = 3; // number of elements
        List<List<Integer>> subSets = new ArrayList<>();

        // Loop through all possible bitmasks
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(i + 1); // elements are 1..n
                }
            }
            subSets.add(subset);
        }

        System.out.println(subSets);
    }
}