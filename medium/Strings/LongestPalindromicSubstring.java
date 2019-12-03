class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        String longestPalindrome = "";
        for (int i = 0; i < s.length()-longestPalindrome.length() / 2; i++)
        {
            int len = Math.max(checkPalindrome(s, i, i), checkPalindrome(s, i, i+1));
            if (len > longestPalindrome.length()) longestPalindrome = s.substring(i - (len-1) / 2, i+len/2+1);
        }
        return longestPalindrome;
    }
    
    public int checkPalindrome(String s, int left, int right)
    {
        int count = left == right ? -1 : 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            count+=2;
            left--;
            right++;
        }
        return count;
    }
}