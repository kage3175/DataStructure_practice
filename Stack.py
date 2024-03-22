class Stack:
  # isEmpty, top, push, pop
  def __init__(self):
    self.size = 0
    self.stack = []
  def isEmpty(self):
    return True if self.size == 0 else False
  def top(self):
    if(self.isEmpty()):
      return -1
    else:
      return self.stack[self.size - 1]
  def push(self, element):
    self.size += 1
    self.stack.append(element)
  def pop(self):
    if(self.isEmpty()):
      return -1
    else:
      a = self.stack.pop()
      self.size -= 1
      return a
  def getStack(self):
    return self.stack
    
test = Stack()
test.push(1)
print(test.getStack())
print(test.pop())
print(test.getStack())