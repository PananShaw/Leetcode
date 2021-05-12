package backtracking.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shaw
 * @describe 39.组合总和
 * @date 2021/05/12 16:10
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] ints = {2, 3, 5};
        System.out.println(combinationSum.combinationSum(ints, 8));
    }

    public List<List<Integer>> res = new ArrayList<>();


    /**
     * @param candidates 元素数组
     * @param target     目标数
     * @return 元素组合列表
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, target, 0, new LinkedList<>());
        return res;
    }

    /**
     * 不对元素列表进行排序，即无法剪枝的做法（排序后可进行剪枝，暂时不写）
     *
     * @param candidates 元素列表
     * @param target     目标数字
     * @param index      当前元素索引
     * @param trace      路径
     */
    public void backtrace(int[] candidates, int target, int index, LinkedList<Integer> trace) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(trace);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == target) {
                trace.add(candidates[i]);
                res.add(new LinkedList<>(trace));
                trace.removeLast();
                continue;
            } else if (candidates[i] > target) {
                continue;
            }
            trace.add(candidates[i]);
            backtrace(candidates, (target - candidates[i]), i, trace);
            trace.removeLast();
        }
    }
}
