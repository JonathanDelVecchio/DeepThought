import jeliot.io.*;
public class myStack {
 public static void main(String[] args) {
 AssemblyLine stack = new AssemblyLine();

 for(int i = 2; i >= 0; i--) {
 stack.push(i);
 }

 for(int i= 0; i < 3; i++) {
 int poped = stack.pop();
 System.out.println("I removed  the item " + poped);
 }
 }
}
 class Node {
 int item;
 Node next;
 }

public class AssemblyLine {

 private Node top;

 public void push( int New ) {
 Node newTop; 
 newTop = new Node();
 newTop.item = New; 
 newTop.next = top; 
 top = newTop; 
 }

 public int pop() {
 if ( top == null )
 throw new IllegalStateException("You can’t pop off an empty stack!");
 int topItem = top.item; 
 top = top.next; 
 return topItem;
 }
 public boolean isEmpty() {
 return (top == null);
 }
 }