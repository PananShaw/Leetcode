package backtracking.medium;

/**
 * @author shaw
 * @describe 1641.统计字典序元音字符串的数目
 * @date 2021/05/12 9:30
 * todo
 */
public class CountVowelStrings {
    public int res = 0;
    public char[] dictionary = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
        backtrace(n, 0, new StringBuilder());
        return res;
    }

    public void backtrace(int n, int index, StringBuilder sb) {
        if (sb.length() == n) {
            res++;
            return;
        }

        for (int i = index; i < n; i++) {
            sb.append(dictionary[i]);
            backtrace(n, i, sb);
            sb.delete(i + 1, sb.length() - 1);
        }
    }
}
