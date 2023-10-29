
public class ClosedHash {
  private int table_size = 0;
  private Entry[] hash;
  private int entrynum = 0;

  private class Entry{
    int key;
    int address;
    boolean deletionMask;
    public Entry(int k, int a){
      key = k;
      address = a;
      deletionMask = false;
    }
    public void deleted(){
      deletionMask = true;
    }
    public void clearMask(){
      deletionMask = false;
    }
    public int getKey(){
      return key;
    }
    public int getAddress(){
      return address;
    }
    public boolean getMask(){
      return deletionMask;
    }
  }

  public ClosedHash(int size){
    table_size = size;
    hash = new Entry[size];
  }

  public int incrementIdx(int idx){
    if(idx == table_size - 1) return 0;
    return ++idx;
  }

  public int hashFunction(int key){ // Linear Probing
    int idx = key % table_size;
    if(hash[idx] == null) return idx;
    idx = incrementIdx(idx);
    while(hash[idx]!=null && !hash[idx].getMask() && hash[idx].getKey() != key){
      if(idx == table_size-1) {idx = 0;}
      else idx++;
    }
    return idx;
  }

  public void insert(int key, int address){
    if(entrynum == table_size){ //Overflow
      System.out.println("Too many entries.");
      return;
    }
    entrynum++;
    int idx = hashFunction(key);
    Entry node = new Entry(key, address);
    hash[idx] = node;
  }

  public int searchIdx(int key){
    int idx = key % table_size;
    int checkpoint = idx;
    if(hash[idx].getKey() == key && !hash[idx].getMask()) return idx;
    idx = incrementIdx(idx);
    while(idx!=checkpoint){
      if(hash[idx]==null) break;
      if(hash[idx].getKey() == key && !hash[idx].getMask()) return idx;
      idx = incrementIdx(idx);
    }
    System.out.println("No such key found.");
    return -1;
  }

  public int search(int key){
    int idx = searchIdx(key);
    if(idx == -1) return 0;
    return hash[idx].getAddress();
  }

  public int delete(int key){
    int idx = searchIdx(key);
    if(idx == -1) return 0;
    entrynum--;
    hash[idx].deleted();
    return hash[idx].getAddress();
  }

  public void print(){
    for(int i = 0;i < table_size;i++){
      System.out.print(i + "\t");
      if(hash[i] == null){
        System.out.println("null");
      }else if(hash[i].getMask()){
        System.out.println("deleted");
      }else{
        System.out.println(hash[i].getKey()+": "+hash[i].getAddress());
      }
    }
  }
}