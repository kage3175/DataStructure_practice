// Hash function is H(x) = x mod size
// 

public class ClosedHash{
  private int entry = 0;
  private int table_size = 0;
  private LinkedList[] hash; 

  public class LinkedList{
    int key;
    LinkedList next;
    int address;

    public LinkedList(){
      key = 0;
      next = null;
      address = 0;
    }
  }

  public int numEntry(){
    return entry;
  }

  public ClosedHash(int size){
    table_size = size;
    hash = new LinkedList[size];
  }

  public int hashFunction(int key){
    return key % table_size;
  }

  public void insert(int key, int address){
    int loc = hashFunction(key);
    LinkedList node = new LinkedList();
    node.key = key;
    node.address = address;
    if(hash[loc]==null){ //First access to this entry
      hash[loc] = node;
    }else{
      LinkedList tmp = hash[loc];
      while(tmp.next != null){
        tmp = tmp.next;
      }
      tmp.next = node;
    }
    entry++;
  }

  public int search(int key){
    int loc = hashFunction(key);
    LinkedList tmp = hash[loc];
    if(tmp == null){ //not found
      return 0;
    }
    if(tmp.key == key) return tmp.address;
    while(tmp.next != null){
      tmp = tmp.next;
      if(tmp.key == key) return tmp.address;
    }
    return 0; //if not found
  }

  public void print(){
    for(int i = 0; i < table_size; i++){
      if(hash[i] == null){
        System.out.println("-");
      }
      else{
        LinkedList tmp = hash[i];
        System.out.print(tmp.key + ": " + tmp.address);
        while(tmp.next != null){
          tmp = tmp.next;
          System.out.print(" -> " + tmp.key + ": " + tmp.address);
        }
        System.out.println("");
      }
    }
  }
}