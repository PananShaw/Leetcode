package backtracking.medium;

import java.util.*;

/**
 * @author shaw
 * @describe 78.子集
 * @date 2021/05/11 15:01
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int num, int[] nums, List<List<Integer>> result, ArrayList<Integer> ans) {
        result.add(new ArrayList<>(ans));
        for (int i = num; i < nums.length; i++) {
            ans.add(nums[i]);
            backtrack(i + 1, nums, result, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
