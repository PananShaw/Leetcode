package backtracking.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaw
 * @describe 401.二进制手表
 * @date 2021-05-11 11:45:00
 */
public class ReadBinaryWatch {
    List<String> result = new ArrayList<>();
    int[] hours = {1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    int[] minutes = {0, 0, 0, 0, 1, 2, 4, 8, 16, 32};

    /**
     * @param turnedOn 亮起灯数
     * @return 结果集
     * @describe 二进制手表主要方法
     */
    public List<String> readBinaryWatch(int turnedOn) {
        backtrack(turnedOn, 0, 0, 0);
        return result;
    }

    public void backtrack(int turnedOn, int index, int hour, int minute) {
        //合理性校验
        if (hour > 11 || minute > 59) {
            return;
        }

        //结束条件
        if (turnedOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            result.add(sb.toString());
            return;
        }

        for (int i = index; i < 10; i++) {
            backtrack(turnedOn - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }
}
