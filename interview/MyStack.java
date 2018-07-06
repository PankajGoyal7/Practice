/*
* @Author: pankajgoyal7
* @Date:   2018-06-13 20:37:43
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-30 06:53:08
*/
import java.util.Stack;

class MyStack{
	int minEle = Integer.MAX_VALUE;
	Stack<Integer> s;
	MyStack(){
		s = new Stack<Integer>();
	}

	void getMin(){
		if(s.isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}else{
			System.out.println(minEle);
		}

	}
	void push(int i){
		if(s.isEmpty()){
			s.push(i);
			minEle = i;
			return;
		}

		if(i < minEle){
			s.push(2*i-minEle);
			minEle = i;
		}else{
			s.push(i);
		}
	}

	void peek(){
		if(s.isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}
		Integer i = s.peek();
		if(i < minEle)
			System.out.println(" Peek Element "+minEle);
		else
			System.out.println(" Peek Element "+i);
	}

	void pop(){
		if(s.isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}

		Integer i = s.pop();
		if(i < minEle){
			System.out.println(" POP Element "+minEle);
			minEle = 2*minEle-i;
		}else{
			System.out.println(" POP Element "+i);
		}
	}

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(3);
		s.push(5);
		s.getMin();
		s.push(2);
		s.pop();
		s.push(1);
		s.getMin();
		s.pop();
		s.push(1);
		s.push(-1);
		s.peek();
	}
}