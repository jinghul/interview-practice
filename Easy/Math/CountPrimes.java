/*
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

class Solution {
    public int countPrimes(int n) {
        int[] sieve = new int[n];
        for (int i = 2; i <= n / 2; i++)
        {
            for (int j = i+i; j < n; j+=i)
            {
                sieve[j]++;
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++)
        {
            if (sieve[i] == 0) count++;
        }
        
        return count;
    }
}