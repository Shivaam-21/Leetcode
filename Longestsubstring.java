package LEETCODE;
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxlen = 0;
        int n = s.length();

        while (r < n) {
            char c = s.charAt(r);

            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
            }

            int len = r - l + 1;
            maxlen = Math.max(len, maxlen);

            map.put(c, r);
            r++;
        }
        return maxlen;
    }
}
