import random

### 오름차순 정렬

A = [i for i in range(10000)]
SIZE = 10000

######### Sub functions #######

def isSorted():
  for i in range(SIZE-1):
    if(A[i] >= A[i+1]):
      return False
  return True



######### Sort functions #########
## All returns cnt_swap and cnt_compare

## n^2

def insertionSort():
  cnt_swap = 0
  cnt_compare = 0
  for i in range(1,SIZE):
    temp = A[i]
    for j in range(i-1,-1,-1):
      cnt_compare += 1
      if(A[j] > temp):
        cnt_swap+=1
        A[j+1] = A[j]
      else:
        break
    cnt_swap+=1
    A[j+1] = temp
  return cnt_swap, cnt_compare

def selectionSort():
  pass

def bubbleSortNaive():
  pass

def bubbleSortImproved():
  pass

## n log(n)

def quickSort():
  pass

def mergeSort():
  pass

def radixSort():
  pass

def heapSortNaive():
  pass

def heapSortInplace():
  pass

########## Main #########

def main():
  pass