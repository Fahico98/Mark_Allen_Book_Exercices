
public class Section_16_2_Linked_List_Implementations_Stack {
    
    public static void main(String[] arguments){
        
        ListStack<String> papersStack = new ListStack();
        
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
        
        System.out.println("ListStack...!\n");
        
        System.out.println(papersStack.toString());
        
        System.out.println("-------------------------------------------------");
        
        System.out.println("'" + papersStack.topAndPop() + "' has been removed of the stack...!");
        System.out.println("'" + papersStack.topAndPop() + "' has been removed of the stack...!");
        System.out.println("'" + papersStack.topAndPop() + "' has been removed of the stack...!");
        
        System.out.println("-------------------------------------------------");
        
        System.out.println(papersStack.toString());
    }
}

class ListStack<AnyType>{
    
    private ListStackNode<AnyType> topOfStack = null;
    
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise. 
     */
    public boolean isEmpty(){
        return(topOfStack == null);
    }
    
    /**
     * Make the stack logically empty.
     */
    public void makeEmpty(){
        topOfStack = null;
    }
    
    /**
    * Insert a new item into the stack.
    * @param x the item to insert.
    */
    public void push(AnyType x){
        topOfStack = new ListStackNode<AnyType>(x, topOfStack);
    }
    
    /**
     * Remove the most recently inserted item from the stack.
     * @throws RuntimeException if the stack is empty.
     */
    public void pop(){
        if(isEmpty()){
            throw new RuntimeException("ListStack pop");
        }
        topOfStack = topOfStack.next;
    }
    
    /**
    * Get the most recently inserted item in the stack, does not alter
    * the stack.
    * @return the most recently inserted item in the stack.
    * @throws RuntimeException if the stack is empty.
    */
    public AnyType top(){
        if(isEmpty()){
            throw new RuntimeException( "ListStack top" );
        }
        return(topOfStack.element);
    }
    
    /**
     * Return and remove the most recently inserted item from the stack.
     * @return the most recently inserted item in the stack.
     * @throws RuntimeException if the stack is empty.
     */
    public AnyType topAndPop(){
        if(isEmpty()){
            throw new RuntimeException( "ListStack topAndPop" );
        }
        AnyType topItem = topOfStack.element;
        topOfStack = topOfStack.next;
        return topItem;
    }
    
    /**
     * @return a string whit all elements of the stack
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        ListStackNode<AnyType> bufferNode = topOfStack;
        while(bufferNode != null){
            sb.append("\t").append(bufferNode.element).append("\n");
            bufferNode = bufferNode.next;
        }
        sb.append("]\n");
        return(new String(sb));
    }
}

class ListStackNode<AnyType>{
    
    public AnyType element;
    public ListStackNode next;
    
    public ListStackNode(AnyType theElement){
        this(theElement, null);
    }
    
    public ListStackNode(AnyType theElement, ListStackNode<AnyType> n){
        element = theElement;
        next = n;
    }
}