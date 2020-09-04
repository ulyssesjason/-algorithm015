### 学习笔记


#### Notes





#### Problem Notes

* **Valid Anagram**
  
  if not just lower case, need to really use map instead of counter array

* **Binary Tree Inorder**

  Recursive is easy - 
  Iterative needs to notify updating cursor
	1. always find leftest, use that as start point and store in stack
	2. then always visit data while after popping out
	3. no need to push after updating cursor

* **Top K Frequent Elements**

  Need to have a map to assist, v1 i had a object which is not necessary

