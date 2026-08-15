import java.util.*;

public class SimplePermutations {
    static List<List<Integer>> result = new ArrayList<>();

    private static void permute(List<Integer> nums, List<Integer> current, boolean[] used) {
        if (current.size() == nums.size()) {
            result.add(new ArrayList<>(current)); // add a copy
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (!used[i]) {
                used[i] = true;              // choose
                current.add(nums.get(i));    // include element
                permute(nums, current, used); // explore
                current.remove(current.size() - 1); // backtrack
                used[i] = false;             // unchoose
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        permute(nums, new ArrayList<>(), new boolean[nums.size()]);
        System.out.println(result);
    }
}
 {
    
}
