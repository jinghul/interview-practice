import numpy as np

def sort(a, b, l, r):
    if (not a) or (not b) or l >= r:
        # print("done - l: %d r: %d" % (l, r))
        return
    
    mid = l + (r - l) // 2 # same as (r + l) // 2
    # print("1. %s l: %d r: %d" % (a, l, mid))
    sort(b, a, l, mid)

    # print("2. %s l: %d r: %d" % (a, mid+1, r))
    sort(b, a, mid+1, r)
    merge(a, b, l, mid, r)

def merge(a, b, l, mid, r):
    # print("%s l: %d mid: %d r: %d" % (b, l, mid, r))
    s1 = l
    s2 = mid+1
    for curr in range(l, r + 1):
        # print("curr: %d s1: %d s2: %d" % (curr, s1, s2))
        if s1 > mid or (s2 <= r and b[s2] < b[s1]):
            # print("s2 - a[%d] = %d" % (curr, b[s2]))
            a[curr] = b[s2]
            s2 += 1
        elif s2 > r or b[s1] <= b[s2]:
            # print("s1 - a[%d] = %d" % (curr, b[s1]))
            a[curr] = b[s1]
            s1 += 1
            
NUM_TESTS = 100000
CORRECT = 0
MAX = 100000
MIN = -MAX
SIZE = 1000

print("-------- Mergesort Tests --------")

for _ in range(NUM_TESTS):
    a = np.random.randint(MIN, MAX, size=np.random.randint(0, SIZE)).tolist()
    b = list.copy(a)
    x = sorted(a)
    sort(a, b, 0, len(a) - 1)
    if a == x:
        CORRECT += 1
    else:
        # print("incorrect")
        print("incorrect: " + str(a) + " vs. " + str(x))

print("%d correct out of %d" % (CORRECT, NUM_TESTS)) 