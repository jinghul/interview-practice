class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || s.equals("") || t.equals("")) return "";
        
        int left = 0, right = 0, start = 0, end = s.length() + 1;
        int matched = 0;
        
        int[] tmap = new int[256];
        for (char c : t.toCharArray()) {
            tmap[c]++;
        }
        
        while (left <= s.length() - t.length())
        {
            if (matched < t.length()) {
                if (right == s.length()) break;
                char c = s.charAt(right);
                if (tmap[c] > 0) matched++;
                tmap[c]--;
                right++;
            } else {
                char c = s.charAt(left);
                if (right - left < end - start) {
                    end = right;
                    start = left;
                }
                if (tmap[c] == 0) matched--;
                tmap[c]++;
                left++;
            }
        }
        
        return end - start > s.length() ? "" : s.substring(start, end);
    }
}