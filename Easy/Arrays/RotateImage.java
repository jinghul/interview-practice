/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/770/
*/

// Using reversal than transpose property of matrices for rotation
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n/2; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
        
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n - row; col++)
            {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n-col-1][n-row-1];
                matrix[n-col-1][n-row-1] = temp;
            }
        }
    }
}

// Using pairwise swaps
class Solution1 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++)
        {
            for (int j = i; j < n - i - 1; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = temp;
                
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;
                
                temp = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n - i - 1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
