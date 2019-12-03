class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1)
        {
            return result;
        }
        generateParenthesis(result, "", n, n);
        return result;
    }
    
    public void generateParenthesis(List<String> result, String curr, int left, int right)
    {
        if (right == 0) {
            result.add(curr);
            return;
        }
        
        if (left <= right && left > 0)
        {
            generateParenthesis(result, curr+"(", left-1, right);
        }
        
        if (left != right)
        {
            generateParenthesis(result, curr+")", left, right-1);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        generate(result, n, n, new StringBuilder());
        return result;
    }
    
    public void generate(List<String> result, int left, int right, StringBuilder s)
    {
        if (left == 0 && right == 0)
        {
            result.add(s.toString());
        }
        
        if (left != 0)
        {
            s.append('(');
            generate(result, left - 1, right, s);
        }
        
        if (right > left)
        {
            s.append(')');
            generate(result, left, right - 1, s);
        }
        
        if (s.length() > 0) s.deleteCharAt(s.length()-1);
    }
}