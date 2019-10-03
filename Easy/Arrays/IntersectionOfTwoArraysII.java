/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
*/

// Using sorting and interpolating result onto nums1
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < 1 || nums2.length < 1) return new int[0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < nums1.length && p2 < nums2.length)
        {
            if (nums1[p1] == nums2[p2])
            {
                nums1[p3++] = nums2[p2]; 
                p1++;p2++;
            } else if (nums1[p1] < nums2[p2])
            {
                p1++;
            } else {
                p2++;
            }
        }
        
        return Arrays.copyOf(nums1, p3);
    }
}

// Using one hashmap
class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) return new int[0];
        else if (nums1.length > nums2.length)
        {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        for (int i = 0; i < nums1.length; i++)
        {
            if (!map.containsKey(nums1[i])) map.put(nums1[i], 0);
            map.put(nums1[i], map.get(nums1[i]) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++)
        {
            if (map.isEmpty()) break;
            else if (map.containsKey(nums2[i]))
            {
                result.add(nums2[i]);
                int count = map.get(nums2[i]);
                if (count == 1)
                {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], count - 1);
                }
            }
        }
        
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
        {
            res[i] = result.get(i);
        }
        return res;
    }
}