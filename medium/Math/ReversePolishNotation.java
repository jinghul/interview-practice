class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (String s : tokens)
        {
            int op = parseString(s);
            if (op == 5)
            {
                stack.add(Integer.parseInt(s));
            } else {
                int result;
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                
                if (op == 1) result = a + b;
                else if (op == 2) result = a - b;
                else if (op == 3) result = a * b;
                else result = a / b;
                    
                stack.add(result);
            }
        }
        
        return stack.remove(0);
    }
    
    public int parseString(String s)
    {
        if (s.equals("+")) return 1;
        else if (s.equals("-")) return 2;
        else if (s.equals("*")) return 3;
        else if (s.equals("/")) return 4;
        else return 5;
    }
}