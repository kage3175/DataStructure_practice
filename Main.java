import java.io.*;
import java.util.Scanner;

public class Main {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String input;
    while(true){
      System.out.println("Select your data structure.\n1. Max Heap\n2. Open Hash\n3. Closed Hash\nq. Quit\n");
      System.out.print("Your Selection?: ");
      input = sc.next();
      if(input.equals("1")){
        heapAction(sc);
        System.out.println("Finished Max Heap");
      }else if(input.equals("2")){
        closedhashAction(sc);
        System.out.println("Finished Closed Hash");
      }else if(input.equals("3")){
        openhashAction(sc);
        System.out.println("Finished Open Hash");
      }
      else if(input.equals("q")){
        sc.close();
        return;
      }
      else{
        System.out.println("No such Data structure.");
    }
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

  public static int closedhashAction(Scanner sc){
    int intinput = 0;
    String input;
    System.out.print("Decide your hash table size: ");
    intinput = sc.nextInt();
    OpenHash hash = new OpenHash(intinput);
    while(true){
      input = sc.next();
      if(input.equals("q")){
        return 0;
      }else if(input.equals("p")){
        hash.print();
      }else if(input.equals("i")){
        System.out.print("Key: ");
        int key = sc.nextInt();
        System.out.print("Address: ");
        int address = sc.nextInt();
        hash.insert(key, address);
      }else if(input.equals("s")){
        System.out.print("Key to search: ");
        int key = sc.nextInt();
        int address = hash.search(key);
        if(address == 0){ //failed to search
          System.out.println("No such key in the hash table");
        }else{
          System.out.println(address);
        }
      }
      else{
        System.out.println("No command such like that.");
      }
    }
  }

  public static int openhashAction(Scanner sc){
    int intinput = 0;
    String input;
    System.out.print("Decide your hash table size: ");
    intinput = sc.nextInt();
    ClosedHash hash = new ClosedHash(intinput);
    while(true){
      input = sc.next();
      if(input.equals("q")){
        return 0;
      }else if(input.equals("p")){
        hash.print();
      }else if(input.equals("i")){
        System.out.print("Key: ");
        int key = sc.nextInt();
        System.out.print("Address: ");
        int address = sc.nextInt();
        hash.insert(key, address);
      }else if(input.equals("s")){
        System.out.print("Key to search: ");
        int key = sc.nextInt();
        int address = hash.search(key);
        if(address != 0){
          System.out.println(address);
        }
      }else if(input.equals("d")){
        System.out.print("Key to delete: ");
        int key = sc.nextInt();
        hash.delete(key);
      }
      else{
        System.out.println("No command such like that.");
      }
    }
  }


}
