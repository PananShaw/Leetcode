package backtracking.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shaw
 * @describe 77.组合
 * @date 2021/05/12 8:48
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result, new ArrayDeque<>(), n, k, 1);
        return result;
    }

    public void backtrace(List<List<Integer>> result, ArrayDeque<Integer> ans, int n, int k, int index) {
        if (ans.size() == k) {
            result.add(new LinkedList<>(ans));
            return;
        }

        if (ans.contains(index)) {
            return;
        }

        for (int i = index; i <= (n - (k - ans.size()) + 1); i++) {
            ans.addLast(i);
            backtrace(result, ans, n, k, i + 1);
            ans.removeLast();
        }
    }
}
