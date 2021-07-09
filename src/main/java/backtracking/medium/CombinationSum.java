package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shaw
 * @describe 39.组合总和 40.组合总和2
 * @date 2021/05/12 16:10
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] ints = {10, 1, 2, 7, 6, 1, 5};
        long now = System.currentTimeMillis();
        System.out.println(combinationSum.combinationSum(ints, 8));
        System.out.println(System.currentTimeMillis() - now);
    }

    public List<List<Integer>> res = new ArrayList<>();


    /**
     * @param candidates 元素数组
     * @param target     目标数
     * @return 元素组合列表
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
//        backtrace(candidates, target, 0, new LinkedList<>());
        backtrace2(candidates, target, 0, new LinkedList<>());
        return res;
    }

    /**
     * 组合总和
     * 不对元素列表进行排序，无法剪枝
     * 排序后可进行剪枝
     *
     * @param candidates 元素列表
     * @param target     目标数字
     * @param index      当前元素索引
     * @param trace      路径
     */
    public void backtrace(int[] candidates, int target, int index, LinkedList<Integer> trace) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            } else if (candidates[i] == target) {
                trace.add(candidates[i]);
                res.add(new LinkedList<>(trace));
                trace.removeLast();
                continue;
            }
            trace.add(candidates[i]);
            backtrace(candidates, (target - candidates[i]), i, trace);
            trace.removeLast();
        }
    }

    /**
     * 组合总和2
     * 不对元素列表进行排序，即无法剪枝的做法（排序后可进行剪枝，暂时不写）
     *
     * @param candidates 元素列表
     * @param target     目标数字
     * @param index      当前元素索引
     * @param trace      路径
     */
    public void backtrace2(int[] candidates, int target, int index, LinkedList<Integer> trace) {
        if (target == 0) {
            res.add(new LinkedList<>(trace));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            trace.add(candidates[i]);
            backtrace2(candidates, (target - candidates[i]), i + 1, trace);
            trace.removeLast();
        }
    }
}
