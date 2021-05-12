package backtracking.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shaw
 * @describe 46.全排列
 * @date 2021/05/11 17:41
 */
public class Permute {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new LinkedList<>(), nums);
        return result;
    }

    public void backtrack(LinkedList<Integer> ans, int[] nums) {
        if (nums.length == ans.size()) {
            result.add(new LinkedList<>(ans));
            return;
        }
        for (int num : nums) {
            if (ans.contains(num)) {
                continue;
            }
            ans.add(num);
            backtrack(ans, nums);
            ans.removeLast();
        }
    }
}
