/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length < 1) return result;
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs)
        {
            char[] cmap = new char[26];
            for (int i = 0; i < str.length(); i++) {
                cmap[str.charAt(i)-'a']++;
            }
            
            String query = new String(cmap);
            if (map.containsKey(query))
            {
                map.get(query).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                result.add(group);
                map.put(query, group);
            }
        }
        
        return result;
    }
}