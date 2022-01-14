package task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1 = "aaabbxxxxxtx";
        String s2 = "p1p1p1p";
        func(s1);
        func(s2);
    }

    public static void func(String s) {
        int[] uniqueCh = s.chars().distinct().toArray();
        Map<Character, Long> countOfCh = new HashMap<>();
        for (int unCh:
             uniqueCh) {
            long count = s.chars().filter(ch -> ch == unCh).count();
            countOfCh.put((char) unCh, count);
        }
        List<Map.Entry<Character, Long>> list = new ArrayList<>(countOfCh.entrySet());
        list.sort(Map.Entry.comparingByValue());
        List<Object> answ = new ArrayList<>();
        answ.add(list.get(list.size()-1).getKey());
        answ.add(list.get(list.size()-1).getValue());
        System.out.println(answ.get(0) + ", " + answ.get(1));
    }
}
