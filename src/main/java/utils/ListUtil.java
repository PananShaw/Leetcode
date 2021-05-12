package utils;

import java.util.List;

public class ListUtil {
    public static void printList(List list) {
        for (Object o : list) {
            System.out.print(o + "\t");
        }
    }

    public static void printList2(List<List<Integer>> list) {
        for (List<Integer> integers : list) {
            printList(integers);
            System.out.println();
        }
    }
}
