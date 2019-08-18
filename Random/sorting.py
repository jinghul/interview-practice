# mergesort
# quicksort
# threesum

def mergesort(list):
	if list == None or len(list) < 2:
		return list

	mid = len(list) // 2
	lefta = mergesort(list[:mid])
	righta = mergesort(list[mid:])
	return merge(lefta, righta)

def merge(a, b):
	lmax, rmax = len(a), len(b)
	n = lmax + rmax
	l, r = 0, 0

	res = []
	for i in range(n):
		if l == lmax:
			res += [b[r]]
			r += 1
		elif r == rmax:
			res += [a[l]]
			l += 1
		else:
			if a[l] <= b[r]:
				res += [a[l]]
				l +=1
			else:
				res += [b[r]]
				r +=1
	return res

def quicksort(list):
	qsort(list, 0, len(list)-1)
	return list

def qsort(list, lo, hi):
	if list == None or lo >= hi:
		return
	if len(list) < 2:
		return
	mid = partition(list, lo, hi)
	qsort(list, lo, mid-1)
	qsort(list, mid+1, hi)

def partition(list, lo, hi):
	pivot = list[hi]
	i = lo - 1
	for j in range(lo, hi):
		if list[j] <= pivot:
			i += 1
			list[i], list[j] = list[j], list[i]


	list[hi], list[i+1] = list[i+1], list[hi]
	return i+1


array_tests = [[], [0], [-1], [49,39], [-1,-2,-3], [1,2,3],[0,6,3,4,9,8,5],[5,5,5,5,5,5,3,0,-1],[1000,200,30,80,90,-2,0,59]]
answers = [[],[0],[-1],[39,49],[-3,-2,-1],[1,2,3],[0,3,4,5,6,8,9],[-1,0,3,5,5,5,5,5,5],[-2,0,30,59,80,90,200,1000]]

method = input("Choose your method to test!\n--- q for quicksort\n--- m for mergesort\n\nINPUT: ")
print("\n")

f = mergesort
if method == "m":
	print("TESTING MERGESORT:")
elif method == "q":
	f = quicksort
	print("TESTING QUICKSORT:")

for test,ans in zip(array_tests, answers):
	print("RESULT:  ", str(f(test)))
	print("CORRECT: ", str(ans))
