// 자식 노드는 2*index + 1, 2*index + 2
//부모 노드는 index/2-1

class MaxHeap{

  int size = 0;
  int[] heap = new int[10000];

  public void heapify(int[] original){
    for(int i = size / 2 - 1; i >= 0;i--) siftDown(i);
  }

  public int biggerIndex(int idx1, int idx2){
    if(idx2 >= size) return idx1;
    else{
      return (heap[idx1]>heap[idx2])?idx1:idx2;
    }
  }
  
  public void siftDown(int idx){
    while(!isLeaf(idx)){
      int tmp = biggerIndex(2*idx+1, 2*idx+2);
      if(heap[idx] < heap[tmp]){
        swap(idx, tmp);
      }
      else return;
      idx = tmp;
    }
  }

  public void swap(int idx1, int idx2){
    int tmp = heap[idx1];
    heap[idx1] = heap[idx2];
    heap[idx2] = tmp;
  }

  public boolean isLeaf(int idx){
    if(idx > size / 2) return true;
    else return false;
  }

  public int max(){
    return heap[0];
  }

  public int deleteMax(){
    int tmp = heap[0];
    if(isEmpty()) return -1;
    else if(size==1){
      heap[0] = 0;
      return tmp;
    }
    heap[0] = heap[--size];
    siftDown(0);
    return tmp;
  }

  public void insert(int a){
    heap[size++] = a;
    int tmp = size--;
    while(tmp > 0){
      int parent = tmp / 2 - 1;
      if(heap[parent] < heap[tmp]) {swap(parent, tmp);tmp = parent;}
      else return;
    }
  }

  public boolean isEmpty(){
    return (size > 0)? false:true;
  }
  public static void main(String args[]){

  }

}
