public class Stack {
  private int full_size;
  private int size;
  private int[] stack;
  //isEmpty, isFull, push, pop, printStack

  Stack(int size_){
    full_size = size_;
    size = 0;
    stack = new int[size_];
  }

  public boolean isEmpty(){
    return size == 0;
  }
  public boolean isFull(){
    return size == full_size;
  }
  public void push(int element){
    if(isFull()){
      System.out.println("The stack is full.");
      return;
    }
    else{
      stack[size++] = element;
      return;
    }
  }
  public int top(){
    if(isEmpty()){
      System.out.println("The stack is empty.");
      return -1;
    }
    else{
      return stack[size - 1];
    }
  }
  public int pop(){
    if(isEmpty()){
      System.out.println("The stack is empty");
      return -1;
    }
    else{
      int temp = stack[--size];
      stack[size] = 0;
      return temp;
    }
  }
  public void printStack(){
    System.out.print("{");
    for(int i = 0; i < size; i++){
      System.out.print(stack[i] + ", ");
    }
    System.out.println("}");
  }


  public static void main(String[] args){
    Stack s = new Stack(10);
    s.printStack();
    s.push(1);
    s.printStack();
    System.out.println(s.pop());
    s.printStack();
  }
}
