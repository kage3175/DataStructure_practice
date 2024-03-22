#include <iostream>
#include <cassert>
using namespace std;

class Stack{
    private:
      int* stack;
      int full_size;
      int size;
    public:
      Stack(int size_){
        full_size = size_;
        size = 0;
        stack = new int[full_size];
      }
      bool isEmpty();
      bool isFull();
      void push(int element);
      int pop();
      int top();
      void printStack();
};

bool Stack::isEmpty(){
  return size == 0;
}

bool Stack::isFull(){
  return size == full_size;
}

void Stack::push(int element){
  if(isFull()){
    cout << "Stack is full now. You cannot push an element now." << endl;
    return;
  }
  else{
    stack[size] = element;
    size++;
    return;
  }
}

int Stack::top(){
  if(isEmpty()){
    cout << "The stack is empty now" << endl;
    return -1;
  }
  else{
    return stack[size - 1];
  }
}

int Stack::pop(){
  if(isEmpty()){
    cout << "The stack is empty now" << endl;
    return -1;
  }
  else{
    int temp = stack[--size];
    stack[size] = 0;
    return temp;
  }
}

void Stack::printStack(){
  cout << "{";
  for(int i = 0; i < size; i++){
    cout << stack[i] << ", ";
  }
  cout << "}" << endl;
}


int main(){
  Stack* s = new Stack(10);
  int input;
  s -> push(1);
  s->printStack();
  cout << s->pop() << endl;
  s->printStack();
  cin >> input;

  return 0;
}

