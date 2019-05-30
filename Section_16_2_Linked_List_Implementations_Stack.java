
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
    
    private ListStackNode<AnyType> topStack = null;
    
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise. 
     */
    public boolean isEmpty(){
        return(topStack == null);
    }
    
    /**
     * Make the stack logically empty.
     */
    public void makeEmpty(){
        topStack = null;
    }
    
    /**
    * Insert a new item into the stack.
    * @param x the item to insert.
    */
    public void push(AnyType x){
        topStack = new ListStackNode<AnyType>(x, topStack);
    }
    
    /**
     * Remove the most recently inserted item from the stack.
     * @throws RuntimeException if the stack is empty.
     */
    public void pop(){
        if(isEmpty()){
            throw new RuntimeException("ListStack pop");
        }
        topStack = topStack.next;
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
        return(topStack.data);
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
        AnyType topItem = topStack.data;
        topStack = topStack.next;
        return topItem;
    }
    
    /**
     * @return a string whit all elements of the stack
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        ListStackNode<AnyType> bufferNode = topStack;
        while(bufferNode != null){
            sb.append("\t").append(bufferNode.data).append("\n");
            bufferNode = bufferNode.next;
        }
        sb.append("]\n");
        return(new String(sb));
    }
}

class ListStackNode<AnyType>{
    
    public AnyType data;
    public ListStackNode next;
    
    public ListStackNode(AnyType data){
        this(data, null);
    }
    
    public ListStackNode(AnyType data, ListStackNode<AnyType> n){
        this.data = data;
        this.next = n;
    }
}