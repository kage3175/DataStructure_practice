import java.io.*;
import java.util.Scanner;

public class Main {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String input;

    input = sc.next();
    if(input.equals("heap")){
      heapAction(sc);
    }
    

  }

  public static int heapAction(Scanner sc){
    MaxHeap heap = new MaxHeap();
    String input;
    int num;
    while(true){
      input = sc.next();
      if(input.equals("d")){ //delete max
        System.out.println("deleted number: " + heap.deleteMax());
      }else if(input.equals("m")){ //print max
        System.out.println(heap.max());
      }else if(input.equals("p")){
        heap.print();
      }else if(input.equals("q")){
        return 0;
      }else{
        try{
          num = Integer.parseInt(input);
          heap.insert(num);
        }
        catch (NumberFormatException ex){
          ex.printStackTrace(System.out);
          System.out.println("Not a number, nor a command");
        }
      }
    }
  }
}
