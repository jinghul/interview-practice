/*
  Fizz Buzz
Solution
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) return result;
        
        for (int i = 1; i <= n; i++)
        {
            String line = "";
            
            if (i % 3 == 0) {
                line += "Fizz";
            }
            
            if (i % 5 == 0)
            {
                line += "Buzz";
            }
            
            if (line.equals("")) line += i;
            result.add(line);
        }
        
        return result;
    }
}