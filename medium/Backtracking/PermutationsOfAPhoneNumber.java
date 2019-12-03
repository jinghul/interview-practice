class Solution {
    String[][] numChar = new String[][] {
        {"a", "b", "c"}, 
        {"d", "e", "f"},
        {"g", "h", "i"},
        {"j", "k", "l"},
        {"m", "n", "o"},
        {"p", "q", "r", "s"},
        {"t", "u", "v"},
        {"w", "x", "y", "z"}
    };
    
    String digits;
    List<String> result;
    
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() < 1) return result;
        this.digits = digits;
        
        addLetters("", 0);
        return result;
    }
    
    public void addLetters(String root, int index)
    {
        if (index == digits.length()) {
            result.add(root);
        } else {
            for (String s : numChar[digits.charAt(index)-'2'])
            {
                addLetters(root + s, index+1);
            }
        }
        
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        
        String[][] map = new String[][]
        {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
        };
        
        List<String> prev = new ArrayList<>();
        prev.add("");
        
        for (int i = digits.length() - 1; i >= 0; i--)
        {
            int digit = digits.charAt(i) - '2';
            List<String> curr = new ArrayList<>();
            for (String s : prev) {
                for (String c : map[digit])
                {
                    curr.add(c + s);
                }
            }
            prev = curr;
        }
        
        return prev;
    }
}