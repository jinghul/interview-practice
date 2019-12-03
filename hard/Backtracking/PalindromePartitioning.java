// Solution 1: Backtracking with Curr Map
class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return new ArrayList<List<String>>();
        
        // dp array, keep list of lists of string for each substring
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<String>(), s, 0);
        return result;
    }
    
    public void partition(List<List<String>> result, List<String> curr, String s, int index)
    {
        if (index >= s.length()) result.add(new ArrayList<String>(curr));
        for (int i = index + 1; i <= s.length(); i++)
        {
            if (isPalindrome(s, index, i - 1))
            {
                curr.add(s.substring(index, i));
                partition(result, curr, s, i);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end)
    {
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

// Solution 2: Backtracking with DP
class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return new ArrayList<List<String>>();
        
        // dp array, keep list of lists of string for each substring
        List<List<String>>[] result = new ArrayList[s.length()];
        return partition(result, s, 0);
    }
    
    public List<List<String>> partition(List<List<String>>[] result, String s, int index)
    {
        if (index >= s.length()) {
            List<List<String>> rl = new ArrayList<>();
            rl.add(new ArrayList<String>());
            return rl;
        }
        else if (result[index] != null) return result[index];
        
        List<List<String>> list = new ArrayList<>();
        
        for (int i = index + 1; i <= s.length(); i++)
        {
            if (isPalindrome(s.substring(index, i)))
            {
                List<List<String>> sublist = partition(result, s, i);
                for (List<String> l : sublist)
                {
                    ArrayList<String> permutation = new ArrayList<>(l.size() + 1);
                    permutation.add(s.substring(index, i));
                    for (String ls : l) permutation.add(ls);
                    list.add(permutation);
                }
            }
        }
        
        result[index] = list;
        return list;
    }
    
    public boolean isPalindrome(String s)
    {
        for (int i = 0; i < s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}