
/*

********** Stack class methods **********

* boolean empty()
Tests if this stack is empty.

* E peek()
Looks at the object at the top of this stack without removing it from the stack.

* E pop()
Removes the object at the top of this stack and returns that object as the value
of this function.

* E push(E item)
Pushes an item onto the top of this stack.}

* int search(Object o)
Returns the 1-based position where an object is on this stack.

*/


import java.util.Stack;

public class Section_6_6_Stacks {
    
    public static void main(String[] arguments){
        
        Stack peopleStack = new Stack();
        
        peopleStack.push("Carlos Gutierrez");
        peopleStack.push("Daniel Corredor");
        peopleStack.push("Jesus Garay");
        peopleStack.push("Martha Cardenaz");
        peopleStack.push("Jose Triana");
        peopleStack.push("Laura Torres");
        
        System.out.println("The last person in the stack is: " + peopleStack.peek() + "...!");
        
        System.out.println("-------------------------------------------------");
        
        System.out.println("'" + peopleStack.pop() + "' has been removed of the stack...!");
        System.out.println("'" + peopleStack.pop() + "' has been removed of the stack...!");
        System.out.println("'" + peopleStack.pop() + "' has been removed of the stack...!");
        
        System.out.println("-------------------------------------------------");
        
        System.out.println("Now, the last person in the stack is: " + peopleStack.peek() + "...!");
        
        System.out.println("-------------------------------------------------");
        
        System.out.println("The people stack is empty: " + peopleStack.isEmpty() + "...!");
    }
}
