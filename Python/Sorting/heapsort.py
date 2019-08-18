import math
import numpy as np

# ascending -> maxheap
def sort(a):
    for i in range(len(a), 0, -1):
        build_heap(a, i)
        a[0], a[i-1] = a[i-1], a[0]

def build_heap(a, end):
    if end == 0:
        return a

    levels = int(math.log(end, 2))
    for i in range(int(2**levels)-2, -1, -1):
        heapify(a, i, end)
    
    return a

def heapify(a, node, end):
    while node != None:
        child = None
        if node * 2 + 2 < end and a[node*2+2] > a[node] and a[node*2+2] > a[node*2+1]:
            child = node * 2 + 2
        elif node * 2 + 1 < end and a[node*2+1] > a[node]:
            child = node * 2 + 1
        
        if child:
            a[node], a[child] = a[child], a[node]
        node = child

NUM_TESTS = 1000
CORRECT = 0
MAX = 100000
MIN = -MAX
SIZE = 1000

print("-------- Heapsort Tests --------")

for _ in range(NUM_TESTS):
    a = np.random.randint(MIN, MAX, size=np.random.randint(0, SIZE)).tolist()
    b = list.copy(a)
    x = sorted(a)
    sort(a)
    if a == x:
        CORRECT += 1
    else:
        pass

print("%d correct out of %d" % (CORRECT, NUM_TESTS)) 