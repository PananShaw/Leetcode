package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shaw
 * @describe 剑指 Offer 61. 扑克牌中的顺子
 * @date 2021/07/09 14:11
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return max - min < 5;
    }

    public boolean isStraight2(int[] nums) {
        int joker = 0;
        // 数组排序
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            // 统计大小王数量
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                // 若有重复，提前返回 false
                return false;
            }
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }
}
