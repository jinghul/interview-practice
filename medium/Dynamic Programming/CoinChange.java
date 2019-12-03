class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        else if (coins.length < 1) return -1;
        Arrays.sort(coins);
        if (amount < coins[0]) return -1;
        
        int[] count = new int[amount + 1];
        for (int coin : coins)
        {
            if (coin > amount) break;
            count[coin] = 1;
            for (int val = coin + 1; val <= amount; val++)
            {
                if (count[val - coin] != 0) 
                {
                    if (count[val] == 0) count[val] = count[val - coin] + 1;
                    else count[val] = Math.min(count[val], count[val - coin] + 1);
                }
            }
        }
        
        return count[amount] == 0 ? -1 : count[amount];
    }
}