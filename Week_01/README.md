### 学习笔记


#### Notes





#### Problem Notes

* **Three sum**
  
  one + two sum: (double pointer or set)

* **Moving zero**
  O(n^2), consider outer loop as new array

* **Reverse Linked List**

  easy to forget - sequence of change the order,
  to remember:
  
  1. temp next in iterative process
  2. twist back current pointing direction
  3. current finally move to next
  4. return prev

* **Rotate Array**

  1. easy to find one extra array solution
  2. three reverse is good and tricky:
	a.  reverse the whole array
	b.  reverse first k 
	c.  reverse the rest

* **Linked List Cyle**

  1. coding has tough spot, if while loop to control slow != fast, then initial state should be different

* **Min Stack**
  
  1. easy to think the solution as `heap + stack`, but pop() operation is O(n) (others are all O(1))
  2. consider using two stacks, with `min stack`, only push the smaller ones in, only pop when stack.peek is also min stack's top

* **Largest Rectangle in Histogram**

  1. O(n^2) solution is not super hard to figure out


