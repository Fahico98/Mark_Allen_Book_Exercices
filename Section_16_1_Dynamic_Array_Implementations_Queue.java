
/* 

Array-based Queue...! 

Note:
a = 5; b = ++a; // a = 6, b = 6
a = 5; b = a++; // a = 6, b = 5

*/

public class Section_16_1_Dynamic_Array_Implementations_Queue {
    
    public static void main(String[] arguments){
        
        ArrayQueue<String> papersQueue = new ArrayQueue();
        
        papersQueue.enqueue("Washington Post");
        papersQueue.enqueue("Wall Street Journal");
        papersQueue.enqueue("The Guardian");
        papersQueue.enqueue("The Citizen");
        papersQueue.enqueue("New Yorck Times");
        papersQueue.enqueue("The Economist");
        papersQueue.enqueue("Nature");
        papersQueue.enqueue("National Geographic");
        papersQueue.enqueue("Rolling Stones");
        papersQueue.enqueue("The New Herald");
        papersQueue.enqueue("The Oxford Gazette");
        papersQueue.enqueue("Times");
        papersQueue.enqueue("Forbes");
        
        System.out.println(papersQueue.toString());
        
        System.out.println("-------------------------------------------------");
        
        System.out.println("'" + papersQueue.dequeue() + "' has been removed of the stack...!");
        System.out.println("'" + papersQueue.dequeue() + "' has been removed of the stack...!");
        System.out.println("'" + papersQueue.dequeue() + "' has been removed of the stack...!");
        
        System.out.println("-------------------------------------------------");
        
        System.out.println(papersQueue.toString());
    }
}

class ArrayQueue<AnyType>{
    
    private AnyType[] theArray;
    private int currentSize;
    private int front;
    private int back;
    private static final int DEFAULT_CAPACITY = 10;
    
    /**
     * Construct the queue.
     */
    public ArrayQueue(){
        theArray = (AnyType []) new Object[DEFAULT_CAPACITY];
        makeEmpty();
    }
    
    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty(){
        return(currentSize == 0);
    }
    
    /**
     * Make the queue logically empty.
     */
    public void makeEmpty(){
        currentSize = 0;
        front = 0;
        back = -1;
    }
    
    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    public void enqueue(AnyType x){
        if(currentSize == theArray.length){
            doubleQueue();
        }
        back = increment(back);
        theArray[back] = x;
        currentSize++;
    }
    
    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @throws RuntimeException if the queue is empty.
     */
    public AnyType dequeue(){
        if(isEmpty()){
            throw new RuntimeException("ArrayQueue dequeue");
        }
        currentSize--;
        AnyType returnValue = theArray[front];
        front = increment(front);
        return returnValue;
    }
    
    /**
     * Get the least recently inserted item in the queue, does not alter
     * the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public AnyType getFront(){
        if(isEmpty()){
            throw new RuntimeException("ArrayQueue getFront");
        }
        return theArray[front];
    }
    
    /**
     * @return a string whit all elements of the stack
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i = front; i < back; i++){
            if(theArray[i] != null){
                sb.append("\t").append(theArray[i]).append("\n");
            }
        }
        sb.append("]\n");
        return(new String(sb));
    }
    
    /**
     * Internal method to expand theArray.
     */
    private void doubleQueue(){
        AnyType[] newArray;
        newArray = (AnyType []) new Object[theArray.length * 2];
        // Copy elements that are logically in the queue
        for(int i = 0; i < currentSize; i++, front = increment(front)){
            newArray[i] = theArray[front];
        }
        theArray = newArray;
        front = 0;
        back = currentSize - 1;
    }
    
    /**
     * Internal method to increment with wraparound.
     * @param x any index in theArray's range.
     * @return x + 1, or 0 if x is at the end of theArray.
     */
    private int increment( int x ){
        if(++x == theArray.length){
            x = 0;
        }
        return x;
    }
}