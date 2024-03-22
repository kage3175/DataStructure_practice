import random
import time

### 오름차순 정렬

A = [i for i in range(10000)]
SIZE = len(A)

CNT_SWAP = 0
CNT_COMPARE = 0

######### Sub functions #######

def isSorted():
  for i in range(SIZE-1):
    if(A[i] >= A[i+1]):
      return False
  return True

def swap(a, b):
  tmp = A[a]
  A[a] = A[b]
  A[b] = tmp

def isLeaf(idx, n):
  if(idx >= n // 2):
    return True
  else:
    return False

def siftDown_min(idx,n):
  global CNT_COMPARE
  global CNT_SWAP
  tmp = idx
  while(not isLeaf(tmp,n)):
    if(n <= 2*tmp+2):
      smaller = 2*tmp+1
    else:
      CNT_COMPARE+=1
      smaller = (2*tmp + 2 if (A[2*tmp+1] > A[2*tmp+2]) else 2*tmp + 1)
    CNT_COMPARE+=1
    if A[smaller] < A[tmp]:
      CNT_SWAP+=1
      swap(smaller, tmp)
    else:
      return
    tmp = smaller


def heapify_min():
  global CNT_COMPARE
  global CNT_SWAP
  for i in range(SIZE//2 - 1, -1,-1):
    siftDown_min(i,SIZE)

def siftDown_max(idx, n):
  global CNT_COMPARE
  global CNT_SWAP
  tmp = idx
  while(not isLeaf(tmp,n)):
    if(n <= 2*tmp+2):
      bigger = 2*tmp+1
    else:
      CNT_COMPARE+=1
      bigger = (2*tmp + 2 if (A[2*tmp+1] < A[2*tmp+2]) else 2*tmp + 1)
    CNT_COMPARE+=1
    if A[bigger] > A[tmp]:
      CNT_SWAP+=1
      swap(bigger, tmp)
    else:
      return
    tmp = bigger

def heapify_max():
  global CNT_COMPARE
  global CNT_SWAP
  for i in range(SIZE//2 -1 ,-1,-1):
    siftDown_max(i, SIZE)

def heapRemoveMin(n):
  if(n==1):
    return A[0]
  tmp = A[0]
  n-=1
  A[0] = A[n]
  siftDown_min(0,n)
  return tmp

def heapRemoveMax(n):
  if(n==1):
    return A[0]
  tmp = A[0]
  n-=1
  A[0] = A[n]
  siftDown_max(0,n)
  return tmp


######### Sort functions #########
## All returns cnt_swap and cnt_compare

## n^2

def insertionSort():
  cnt_swap = 0
  cnt_compare = 0
  for i in range(1,SIZE):
    temp = A[i]
    j = i - 1
    while(j >= 0 and A[j] > temp):
      cnt_compare += 1
      cnt_swap+=1
      A[j+1] = A[j]
      j-=1
    cnt_swap+=1
    A[j+1] = temp
  return cnt_swap, cnt_compare

def selectionSort():
  cnt_swap = 0
  cnt_compare = 0
  for i in range(SIZE-1):
    min = A[i]
    minIdx = i
    for j in range(i,SIZE,1):
      cnt_compare+=1
      if(min > A[j]):
        min = A[j]
        minIdx = j
    cnt_swap+=1
    swap(i,minIdx)
  return cnt_swap, cnt_compare

def bubbleSortNaive():
  cnt_swap = 0
  cnt_compare = 0
  for i in range(SIZE - 1):
    for j in range(SIZE - 1, i, -1):
      cnt_compare+=1
      if(A[j - 1] > A[j]):
        cnt_swap+=1
        swap(j,j-1)
  return cnt_swap, cnt_compare

def bubbleSortImproved():
  cnt_swap = 0
  cnt_compare = 0
  bound = -1
  while(bound < SIZE - 1):
    temp = SIZE - 1
    for i in range(SIZE - 1, bound+1,-1):
      cnt_compare+=1
      if(A[i-1] > A[i]):
        cnt_swap+=1
        swap(i-1,i)
        temp = i-1
    bound = temp
  return cnt_swap, cnt_compare

## n log(n)

def quickSort():
  cnt_swap = 0
  cnt_compare = 0
  stack = []
  stack.append((0,SIZE-1))
  while(stack):
    left, right = stack.pop()
    i, j = left, right+1
    pivot = A[left]
    #print(pivot)
    while(i < j):
      i+=1
      cnt_compare+=1
      while(i < right and A[i] < pivot):
        cnt_compare+=1
        i+=1
      j-=1
      cnt_compare+=1
      while(j > left and A[j] > pivot):
        cnt_compare+=1
        j-=1
      if(i < j):
        cnt_swap+=1
        swap(i,j)
    cnt_swap+=1
    swap(left,j)
    if(left < j - 1):
      stack.append((left,j-1))
    if(j+1 < right):
      stack.append((j+1,right))
  return cnt_swap, cnt_compare

def mergeSort():
  pass

def radixSort():
  pass

def heapSortNaive():
  global CNT_COMPARE
  global CNT_SWAP
  CNT_COMPARE = 0
  CNT_SWAP = 0
  heapify_min()
  B = [0 for i in range(SIZE)]
  for i in range(SIZE):
    B[i] = heapRemoveMin(SIZE - i)
  for i in range(SIZE):
    A[i] = B[i]
  return CNT_SWAP, CNT_COMPARE
  

def heapSortInplace():
  global CNT_COMPARE
  global CNT_SWAP
  CNT_COMPARE = 0
  CNT_SWAP = 0
  heapify_max()
  for i in range(SIZE):
    A[SIZE-1-i] = heapRemoveMax(SIZE-i)
  return CNT_SWAP, CNT_COMPARE

###################### Main #######################################

def main():
  random.shuffle(A)
  start = time.time()
  cnt_swap, cnt_compare = selectionSort()
  end = time.time() - start
  print("Selection sort: {success}\nTime: {time} sec\nTotal swap: {swap}\tTotal compare: {compare}\n".\
        format(success = ("succeeded" if isSorted() else "failed"), time = end, swap = cnt_swap, compare = cnt_compare))
  random.shuffle(A)
  start = time.time()
  cnt_swap, cnt_compare = bubbleSortNaive()
  end = time.time() - start
  print("Bubble sort(Naive): {success}\nTime: {time} sec\nTotal swap: {swap}\tTotal compare: {compare}\n".\
        format(success = ("succeeded" if isSorted() else "failed"), time = end, swap = cnt_swap, compare = cnt_compare))
  random.shuffle(A)
  start = time.time()
  cnt_swap, cnt_compare = bubbleSortImproved()
  end = time.time() - start
  print("Bubble sort(Improved): {success}\nTime: {time} sec\nTotal swap: {swap}\tTotal compare: {compare}\n".\
        format(success = ("succeeded" if isSorted() else "failed"), time = end, swap = cnt_swap, compare = cnt_compare))
  start = time.time()
  cnt_swap, cnt_compare = bubbleSortImproved()
  end = time.time() - start
  print("Bubble sort(Improved)(Already Sorted): {success}\nTime: {time} sec\nTotal swap: {swap}\tTotal compare: {compare}\n".\
        format(success = ("succeeded" if isSorted() else "failed"), time = end, swap = cnt_swap, compare = cnt_compare))
  random.shuffle(A)
  start = time.time()
  cnt_swap, cnt_compare = quickSort()
  end = time.time() - start
  print("Quick sort: {success}\nTime: {time} sec\nTotal swap: {swap}\tTotal compare: {compare}\n".\
        format(success = ("succeeded" if isSorted() else "failed"), time = end, swap = cnt_swap, compare = cnt_compare))
  random.shuffle(A)
  start = time.time()
  cnt_swap, cnt_compare = heapSortNaive()
  end = time.time() - start
  print("Heap sort(Naive): {success}\nTime: {time} sec\nTotal swap: {swap}\tTotal compare: {compare}\n".\
        format(success = ("succeeded" if isSorted() else "failed"), time = end, swap = cnt_swap, compare = cnt_compare))
  random.shuffle(A)
  start = time.time()
  cnt_swap, cnt_compare = heapSortInplace()
  end = time.time() - start
  print("Bubble sort(In place): {success}\nTime: {time} sec\nTotal swap: {swap}\tTotal compare: {compare}\n".\
        format(success = ("succeeded" if isSorted() else "failed"), time = end, swap = cnt_swap, compare = cnt_compare))

main()