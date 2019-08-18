import numpy as np

# input = list of integers, output = max heaped list
def heapify(nums):
    if not nums.any():
        return nums
    
    for i in range(len(nums)-1, -1, -1):
        sift_up(nums, len(nums), i)
    for i in range(len(nums)-1, 0, -1):
        nums[0], nums[i] = nums[i], nums[0]
        sift_up(nums, i, 0)

def sift_up(nums, length, i):
    curr = i
    left = i*2 + 1
    right = i*2 + 2

    if left < length and nums[curr] < nums[left]:
        curr = left
    if right < length and nums[curr] < nums[right]:
        curr = right
    
    # sift up, because child is larger than current
    if curr != i:
        nums[curr], nums[i] = nums[i], nums[curr]
        sift_up(nums, length, curr)

def driver():
    nums = np.random.randint(100, size=10)
    print("original:", nums)
    heapify(nums)
    print("sorted:",nums)

driver()