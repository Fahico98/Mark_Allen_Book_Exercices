
/*

Array-based Stack...! 

Note:
a = 5; b = ++a; // a = 6, b = 6
a = 5; b = a++; // a = 6, b = 5

*/

public class Section_16_1_Dynamic_Array_Implementations_Stack {
    
    public static void main(String[] arguments){
        
        ArrayStack<String> papersStack = new ArrayStack();
        
        papersStack.push("Washington Post");
        papersStack.push("Wall Street Journal");
        papersStack.push("The Guardian");
        papersStack.push("The Citizen");
        papersStack.push("New Yorck Times");
        papersStack.push("The Economist");
        papersStack.push("Nature");
        papersStack.push("National Geographic");
        papersStack.push("Rolling Stones");
        papersStack.push("The New Herald");
        papersStack.push("The Oxford Gazette");
        papersStack.push("Times");
        papersStack.push("Forbes");
        
        System.out.println("ArrayStack...!\n");
        
        System.out.println(papersStack.toString());
        
        System.out.println("-------------------------------------------------");
        
        System.out.println("'" + papersStack.topAndPop() + "' has been removed of the stack...!");
        System.out.println("'" + papersStack.topAndPop() + "' has been removed of the stack...!");
        System.out.println("'" + papersStack.topAndPop() + "' has been removed of the stack...!");
        
        System.out.println("-------------------------------------------------");
        
        System.out.println(papersStack.toString());
    }
}

class ArrayStack<AnyType>{
    
    private AnyType[] theArray;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 10;
    
    /**
    * @construct the stack
    */
    public ArrayStack(){
        theArray = (AnyType []) new Object[DEFAULT_CAPACITY]; 
        topOfStack = -1;
    }
    
    public ArrayStack(AnyType[] array){
        theArray = array;
        topOfStack = array.length - 1;
    }
    
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise. 
     */
    public boolean isEmpty(){
        return(topOfStack == -1);
    }
    
    /**
     * Make the stack logically empty.
     */
    public void makeEmpty(){
        topOfStack = -1;
    }
    
    /**
     * Get the most recently inserted item in the stack, does not alter
     * the stack.
     * @return the most recently inserted item in the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public AnyType top(){
        if(isEmpty()){
            throw new RuntimeException("ArrayStack top");
        }
        return theArray[topOfStack]; 
    }
    
    /**
     * Remove the most recently inserted item from the stack.
     * @throws RuntimeException if the stack is empty.
     */
    public void pop(){
        if(isEmpty()){
            throw new RuntimeException("ArrayStack top");
        }
        topOfStack--;
    }
    
    /**
     * Return and remove the most recently inserted item from the stack.
     * @return the most recently inserted item in the stack.
     * @throws RuntimeException if the stack is empty. 
     */
    public AnyType topAndPop(){
        if(isEmpty()){
            throw new RuntimeException("ArrayStack top");
        }       
        return theArray[--topOfStack];
    }
    
    /**
     * Insert a new item into the stack. 
     * @param x the item to insert. 
     */
    public void push(AnyType x){
        if(topOfStack + 1 == theArray.length){
            doubleArray();
        }
        theArray[++topOfStack] = x;
    }
    
    /**
     * @return a string whit all elements of the stack
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i = 0; i < topOfStack; i++){
            if(theArray[i] != null){
                sb.append("\t").append(theArray[i]).append("\n");
            }
        }
        sb.append("]\n");
        return(new String(sb));
    }
    
    /**
     * Double the size of the stack.
     */
    private void doubleArray(){
        AnyType[] bufferArray = (AnyType []) new Object[2 * theArray.length];
        System.arraycopy(theArray, 0, bufferArray, 0, theArray.length);
        theArray = bufferArray;
    }
}