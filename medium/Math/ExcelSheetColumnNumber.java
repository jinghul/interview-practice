class Solution {
    public int titleToNumber(String s) {
        int multiplier = 1;
        int total = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            total += multiplier * (s.charAt(i) - 'A' + 1);
            multiplier *= 26;
        }
        return total;
    }
}

class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int counter = s.length();
        for (char c : s.toCharArray())
        {
            counter -= 1;
            sum += (c - 'A' + 1) * Math.pow(26, counter);
        }
        return sum;
    }
}