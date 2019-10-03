/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class Solution {
    public boolean isValid(String s) {
        if (s.equals("")) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
        {
            if (c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                char prev = stack.pop();
                if (c == ')' && prev != '(') return false;
                else if (c == ']' && prev != '[') return false;
                else if (c == '}' && prev != '{') return false;
            } else return false;
        }
        return stack.isEmpty();
    }
}