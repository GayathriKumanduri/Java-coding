package Examples;

import java.util.HashMap;
import java.util.Map;

/* Find the length of the longest substring without repeating characters.
Example:
Input: s = "abcabcbb"
Output: 3(substring "abc")
*/
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
       Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charIndexMap.containsKey(currentChar)) {
                // Move the left pointer to the right of the last occurrence of currentChar
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s)); // Output: 3
    }
    
}
