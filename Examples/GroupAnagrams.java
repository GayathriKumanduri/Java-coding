package Examples;
/*Given an array of strings, group anagrams together.
Example:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(strs);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}

