package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaw
 * @describe 22.括号生成
 * @date 2021/05/11 18:58
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
//        dfs("", 0, 0, n, result);
        backtrace(new StringBuilder(), n, n, result);
        return result;
    }

    /**
     * 深度优先遍历，加算
     *
     * @param ans    当前字符串
     * @param left   当前已使用左括号数量
     * @param right  当前已使用左括号数量
     * @param n      括号对数
     * @param result 结果集
     */
    public void dfs(String ans, int left, int right, int n, List<String> result) {
        if (left == n && right == n) {
            result.add(ans);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(ans + "(", left + 1, right, n, result);
        }

        if (right < n) {
            dfs(ans + ")", left, right + 1, n, result);
        }
    }

    /**
     * 回溯算法，减算
     *
     * @param ans    路径
     * @param left   当前已使用左括号数量
     * @param right  当前已使用左括号数量
     * @param result 结果集
     */
    public void backtrace(StringBuilder ans, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(ans.toString());
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            ans.append("(");
            backtrace(ans, left - 1, right, result);
            ans.deleteCharAt(ans.length() - 1);
        }

        if (right > 0) {
            ans.append(")");
            backtrace(ans, left, right - 1, result);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
}
