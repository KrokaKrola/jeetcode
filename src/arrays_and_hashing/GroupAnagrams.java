package arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            List<String> list;

            if (map.containsKey(String.valueOf(chars))) {
                list = map.get(String.valueOf(chars));
            } else {
                list = new ArrayList<>();
            }

            list.add(str);
            map.put(String.valueOf(chars), list);
        }

        return new ArrayList<>(map.values());
    }
}
