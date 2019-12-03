class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        
        int[][] boundary = new int[][] {
            {0, matrix[0].length - 1},
            {0, matrix.length - 1}
        };
        
        while (boundary[0][0] < boundary[0][1] && boundary[1][0] < boundary[1][1])
        {
            int row = boundary[1][0];
            int col = 0;
            
            // top, left to right
            for (col = boundary[0][0]; col < boundary[0][1]; col++) result.add(matrix[row][col]);
            
            // right, top to bottom
            for (row = row; row < boundary[1][1]; row++) result.add(matrix[row][col]);
            
            // bottom, right to left
            for (col = col; col > boundary[0][0]; col--) result.add(matrix[row][col]);
            
            // right, bottom to top
            for (row = row; row > boundary[1][0]; row--) result.add(matrix[row][col]);
            
            boundary[0][0]++;
            boundary[0][1]--;
            boundary[1][0]++;
            boundary[1][1]--;
        }
        
        if (boundary[0][0] == boundary[0][1])
        {
            int col = boundary[0][0];
            for (int row = boundary[1][0]; row <= boundary[1][1]; row++) result.add(matrix[row][col]);
        } else if (boundary[1][0] == boundary[1][1])
        {
            int row = boundary[1][0];
            for (int col = boundary[0][0]; col <= boundary[0][1]; col++) result.add(matrix[row][col]);
        }
        
        return result;
    }
}