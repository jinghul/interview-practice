/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/601/
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        
        for (int i = 0; i < numRows-1; i++)
        {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            List<Integer> prevRow = result.get(i);
            for (int j = 0; j < prevRow.size() - 1; j++)
            {
                row.add(prevRow.get(j) + prevRow.get(j+1));
            }
            
            row.add(1);
            result.add(row);
        }
        
        return result;
    }
}