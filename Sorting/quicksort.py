import math
import numpy as np

def sort(a, l, r):
    if l >= r:
        return
    
    p = partition(a, l, r)
    sort(a, l, p-1)
    sort(a, p+1, r)

def partition(a, l, r):
    n = a[l]
    t = l+1
    for i in range(l+1, r+1):
        if a[i] <= n:
            a[t], a[i] = a[i], a[t]
            t += 1
    a[l] = a[t-1]
    a[t-1] = n
    return t-1

NUM_TESTS = 1000
CORRECT = 0
MAX = 1000
MIN = -MAX
SIZE = 1000

print("-------- Quicksort Tests --------")

for _ in range(NUM_TESTS):
    a = np.random.randint(MIN, MAX, size=np.random.randint(0, SIZE)).tolist()
    b = list.copy(a)
    x = sorted(a)
    sort(a, 0, len(a)-1)
    if a == x:
        CORRECT += 1
    else:
        pass

print("%d correct out of %d" % (CORRECT, NUM_TESTS)) 